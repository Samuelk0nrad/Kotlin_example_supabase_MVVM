package org.example.project.authentication.pages.LogIn

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
    AuthenticationViewModel: AuthenticationViewModel,
    successfullyLogIn: () -> Unit
) {
    Scaffold {
        Column {
            Text("Log In", style = MaterialTheme.typography.h1)

            TextField(value = AuthenticationViewModel.email.value, onValueChange = { AuthenticationViewModel.setEmail(it) })
            TextField(value = AuthenticationViewModel.password.value, onValueChange = { AuthenticationViewModel.setPassword(it) })

            Button(onClick = { AuthenticationViewModel.LogIn{successfullyLogIn,_ -> if(successfullyLogIn) successfullyLogIn()}}) {
                Text("Log In")
            }
        }
    }
}
