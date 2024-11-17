package org.example.project.authentication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.authentication.pages.logIn.LogIn
import org.example.project.authentication.pages.signUp.SignUp
import org.example.project.authentication.pages.start.Start
import org.example.project.authentication.utils.AuthenticationScreens
import org.example.project.utils.Screens

@Composable
fun Authentication(
    navController: NavHostController,
    authenticationViewModel: AuthenticationViewModel
) {

    val authenticationNavController = rememberNavController()
    NavHost(navController = authenticationNavController, startDestination = AuthenticationScreens.Start.title){

        composable(AuthenticationScreens.Start.title) {

            Start(authenticationNavController)

        }

        composable(AuthenticationScreens.LogIn.title) {

            LogIn(authenticationViewModel){
                navController.navigate(Screens.Page2.title)
            }

        }

        composable(AuthenticationScreens.SignUp.title) {
            SignUp(authenticationViewModel) {
                navController.navigate(Screens.Page2.title)
            }
        }

    }
}