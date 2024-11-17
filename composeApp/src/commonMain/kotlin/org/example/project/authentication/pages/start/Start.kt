package org.example.project.authentication.pages.start

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.example.project.authentication.utils.AuthenticationScreens

@Composable
fun Start(
    navHostController: NavHostController
){
    Scaffold {
        Column {
            Button(onClick = { navHostController.navigate(AuthenticationScreens.LogIn.title) }) {
                Text("Log In")
            }

            Button(onClick = { navHostController.navigate(AuthenticationScreens.SignUp.title) }) {
                Text("Sign Up")
            }
        }
    }
}