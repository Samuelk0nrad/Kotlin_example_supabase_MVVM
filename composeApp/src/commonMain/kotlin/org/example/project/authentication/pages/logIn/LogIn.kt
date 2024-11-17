package org.example.project.authentication.pages.logIn

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun LogIn(successfullyLogIn: () -> Unit) {
    val email =  remember { mutableStateOf("") }
    val password =  remember { mutableStateOf("") }

    Scaffold {
        Column {
            Text("Log In", style = MaterialTheme.typography.h1)

            TextField(value = email.value, onValueChange = { email.value = it })
            TextField(value = password.value, onValueChange = { password.value = it })

            Button(onClick = { successfullyLogIn() }) {
                Text("Log In")
            }
        }
    }
}