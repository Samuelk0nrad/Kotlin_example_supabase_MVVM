package org.example.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.jan.supabase.auth.status.SessionStatus
import org.example.project.authentication.Authentication
import org.example.project.authentication.AuthenticationViewModel
import org.example.project.utils.Screens
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun Navigation(){
    KoinContext {
        val appViewModel = koinViewModel<AppViewModel>()

        // Log In State
        val sessionStatus by appViewModel.sessionStatus.collectAsState()

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screens.Page2.title) {

            composable(Screens.Authentication.title) {

                val viewModel = koinViewModel<AuthenticationViewModel>()

                Authentication(navController, viewModel)

            }

            composable(Screens.Page2.title) {

            }
        }

        // Check if the user is authenticated if not navigate to the authentication screen
        LaunchedEffect(sessionStatus) {
            when (sessionStatus) {
                is SessionStatus.NotAuthenticated -> {
                    navController.navigate(Screens.Authentication.title)
                }
                is SessionStatus.RefreshFailure -> {
                    navController.navigate(Screens.Authentication.title)
                }
                else -> {
                    // Do nothing
                }
            }
        }
    }
}