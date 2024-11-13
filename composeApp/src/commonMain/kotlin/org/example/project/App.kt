package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.coroutines.*
import org.example.project.pages.Authentication.RegistrationPage
import org.example.project.pages.Data.DataPage
import org.example.project.utils.Country

val supabase = createSupabaseClient(
    supabaseUrl = "https://kfvqfwajrrrveegoihrc.supabase.co",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImtmdnFmd2FqcnJydmVlZ29paHJjIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzA3MTQ0MTYsImV4cCI6MjA0NjI5MDQxNn0.D-TC5JTneStsuCHt8cqvvHk8IeeeoULdVgqNrJm__Jo"
) {
    install(Postgrest)
    install(Auth)
}

@Composable
@Preview
fun App() {
    MaterialTheme {
       Navigation()
    }
}

suspend fun CreateAccount(newEmail: String, newPassword: String): Boolean {
    return try {
        // Attempt to sign up with email and password
        supabase.auth.signUpWith(Email) {
            email = newEmail
            password = newPassword
        }
        true // Return true on success
    } catch (e: Exception) {
        e.printStackTrace() // Print the exception for debugging
        false // Return false if an error occurred
    }
}

suspend fun LogIn(newEmail: String, newPassword: String): Boolean {
    return try {
        // Attempt to sign up with email and password
        supabase.auth.signInWith(Email) {
            email = newEmail
            password = newPassword
        }
        true // Return true on success
    } catch (e: Exception) {
        e.printStackTrace() // Print the exception for debugging
        false // Return false if an error occurred
    }
}


fun insertData(country: Country) {
    runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine and continue
            supabase.from("countries").insert(country)
        }
    }
}