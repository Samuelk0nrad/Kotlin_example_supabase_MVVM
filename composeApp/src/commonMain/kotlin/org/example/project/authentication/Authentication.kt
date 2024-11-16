package org.example.project.authentication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.authentication.pages.LogIn.LogIn
import org.example.project.authentication.pages.SignUp.SignUp
import org.example.project.authentication.pages.Start.Start
import org.example.project.authentication.utils.AuthenticationScreen
import org.example.project.utils.Screen

@Composable
fun Authentication(
    authenticationViewModel: AuthenticationViewModel,
    navHostController: NavHostController
){
    val authenticationNavController: NavHostController = rememberNavController()
    NavHost(navController = authenticationNavController, startDestination = AuthenticationScreen.Start.title) {

        composable(AuthenticationScreen.Start.title) {
            Start(authenticationNavController)
        }

        composable(AuthenticationScreen.LogIn.title) {

            LogIn(authenticationViewModel){
                navHostController.navigate(Screen.Data.title)
            }
        }

        composable(AuthenticationScreen.SignUp.title) {
            SignUp(authenticationViewModel){
                navHostController.navigate(Screen.Data.title)
            }
        }
    }
}