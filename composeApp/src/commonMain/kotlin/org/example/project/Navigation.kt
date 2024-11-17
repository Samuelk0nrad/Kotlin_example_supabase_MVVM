package org.example.project

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.authentication.Authentication
import org.example.project.utils.Screens

@Composable
fun Navigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Authentication.title){

        composable(Screens.Authentication.title) {

            Authentication(navController)

        }

        composable(Screens.Page2.title) {

        }

    }
}