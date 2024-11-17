package org.example.project.authentication.pages.logIn

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import org.example.project.authentication.AuthenticationViewModel

@Composable
fun LogIn(
    authenticationViewModel: AuthenticationViewModel,
    successfullyLogIn: () -> Unit
) {

    Scaffold {
        Column {
            Text("Log In", style = MaterialTheme.typography.h1)

            TextField(value = authenticationViewModel.email.value, onValueChange = { authenticationViewModel.setEmail(it) })
            TextField(value = authenticationViewModel.password.value, onValueChange = { authenticationViewModel.setPassword(it) })

            Button(onClick = { authenticationViewModel.LogIn{successfullyLogIn,_ -> if(successfullyLogIn) successfullyLogIn()} }) {
                Text("Log In")
            }
        }
    }
}