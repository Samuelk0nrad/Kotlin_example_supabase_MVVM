package org.example.project.authentication

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.coroutines.launch

class AuthenticationViewModel (
    private val supabaseClient: SupabaseClient
) : ViewModel() {
    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }


    fun LogIn(callback:(Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                // Attempt to sign up with email and password
                supabaseClient.auth.signInWith(Email) {
                    email = _email.value
                    password = _password.value
                }
                callback(true, null)
            } catch (e: Exception) {
                e.printStackTrace()
                callback(false, e.message)
            }
        }
    }

    fun SignUp(callback:(Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                // Attempt to sign up with email and password
                supabaseClient.auth.signUpWith(Email) {
                    email = _email.value
                    password = _password.value
                }
                callback(true, null)
            } catch (e: Exception) {
                e.printStackTrace()
                callback(false, e.message)
            }
        }
    }
}