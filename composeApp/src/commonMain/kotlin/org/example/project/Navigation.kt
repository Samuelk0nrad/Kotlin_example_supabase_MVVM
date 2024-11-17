package org.example.project

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screens.Authentication.title) {

            composable(Screens.Authentication.title) {

                val viewModel = koinViewModel<AuthenticationViewModel>()

                Authentication(navController, viewModel)

            }

            composable(Screens.Page2.title) {

            }

        }
    }
}