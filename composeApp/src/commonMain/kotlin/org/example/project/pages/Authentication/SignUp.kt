package org.example.project.pages.Authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import kotlinx.coroutines.launch
import org.example.project.CreateAccount
import org.example.project.LogIn


@Composable
fun RegistrationPage() {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var registrationSuccessful by remember { mutableStateOf<Boolean?>(null) } // Track registration status
    val coroutineScope = rememberCoroutineScope() // Scope for launching coroutines

    Scaffold {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Column {
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") }
                    )
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") }
                    )
                    TextButton(onClick = {
                        // Launch coroutine for registration in the correct scope
                        coroutineScope.launch {
                            registrationSuccessful = CreateAccount(email.text, password.text)
                        }
                    }) {
                        Text("Create Account")
                    }

                    TextButton(onClick = {
                        // Launch coroutine for registration in the correct scope
                        coroutineScope.launch {
                            registrationSuccessful = LogIn(email.text, password.text)
                        }
                    }) {
                        Text("Log In")
                    }


                    // Display registration result message
                    when (registrationSuccessful) {
                        true -> Text("Registration Successful!")
                        false -> Text("Registration Failed. Please try again.")
                        null -> {} // No message if registration status is not yet determined
                    }
                }
            }
        }
    }
}