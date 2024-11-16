package org.example.project.authentication.pages.Start

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.example.project.authentication.utils.AuthenticationScreen

@Composable
fun Start(
    navHostController: NavHostController
){
    Scaffold {
        Column {
            Button(onClick = { navHostController.navigate(AuthenticationScreen.LogIn.title) }) {
                Text("Log In")
            }

            Button(onClick = { navHostController.navigate(AuthenticationScreen.SignUp.title) }) {
                Text("Sign Up")
            }
        }
    }
}