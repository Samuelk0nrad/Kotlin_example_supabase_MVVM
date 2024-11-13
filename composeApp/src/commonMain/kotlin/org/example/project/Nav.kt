package org.example.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.pages.Authentication.RegistrationPage
import org.example.project.pages.Data.DataPage
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun Navigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Registration.title){
        composable(Screen.Data.title){
            DataPage()
        }

        composable(Screen.Registration.title){
            RegistrationPage()
        }
    }
}