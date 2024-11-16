package org.example.project.authentication.pages.SignUp


import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import org.example.project.authentication.AuthenticationViewModel


@Composable
fun SignUp(
    authenticationViewModel: AuthenticationViewModel,
    successfullySignUp: () -> Unit
) {
    Scaffold {
        Column {
            Text("Sign Up", style = MaterialTheme.typography.h1)

            TextField(value = authenticationViewModel.email.value, onValueChange = { authenticationViewModel.setEmail(it) })
            TextField(value = authenticationViewModel.password.value, onValueChange = { authenticationViewModel.setPassword(it) })

            Button(onClick = { authenticationViewModel.SignUp{successfullySignUp,_ -> if(successfullySignUp) successfullySignUp()}}) {
                Text("Sign Up")
            }
        }
    }
}