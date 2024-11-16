package org.example.project

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.authentication.Authentication
import org.example.project.authentication.AuthenticationViewModel
import org.example.project.pages.Data.DataPage
import org.example.project.pages.Data.DataViewModel
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
        val startScreen = Screen.Data.title
        appViewModel.isUserLogedIn{
            printLog("Session", "User not loged in $it")
        }

        NavHost(navController = navController, startDestination = startScreen) {
            composable(Screen.Authentication.title) {
                val viewModel = koinViewModel<AuthenticationViewModel>()
                Authentication(viewModel, navController)
            }

            composable(Screen.Data.title) {
                val viewModel = koinViewModel<DataViewModel>()
                DataPage(viewModel)
            }
        }
    }
}