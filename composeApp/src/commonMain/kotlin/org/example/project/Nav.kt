package org.example.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.jan.supabase.auth.status.SessionStatus
import org.example.project.authentication.Authentication
import org.example.project.authentication.AuthenticationViewModel
import org.example.project.pages.data.DataPage
import org.example.project.pages.data.DataViewModel
import org.example.project.utils.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun Navigation() {
    val navController: NavHostController = rememberNavController()
    KoinContext {
        val appViewModel = koinViewModel<AppViewModel>()

        NavHost(navController = navController, startDestination =  Screen.Data.title) {
            composable(Screen.Authentication.title) {
                val viewModel = koinViewModel<AuthenticationViewModel>()
                Authentication(viewModel, navController)
            }

            composable(Screen.Data.title) {
                val viewModel = koinViewModel<DataViewModel>()
                DataPage(viewModel)
            }
        }


        // Check if the user is authenticated if not navigate to the authentication screen
        val sessionStatus by appViewModel.sessionStatus.collectAsState()

        LaunchedEffect(sessionStatus) {
            when (sessionStatus) {
                is SessionStatus.Authenticated -> {
                    printLog("Supabase-Auth", "Authenticated")
                }
                is SessionStatus.NotAuthenticated -> {
                    printLog("Supabase-Auth", "Not Authenticated")
                    navController.navigate(Screen.Authentication.title)
                }
                is SessionStatus.RefreshFailure -> {
                    printLog("Supabase-Auth", "Refresh Failure")
                    navController.navigate(Screen.Authentication.title)
                }
                is SessionStatus.Initializing -> {
                    printLog("Supabase-Auth", "Initializing")
                }
            }
        }
    }
}