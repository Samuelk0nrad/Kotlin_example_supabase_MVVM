package org.example.project

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.user.UserSession
import kotlinx.coroutines.launch
import org.example.project.authentication.data.SessionManager

class AppViewModel(
    private val supabaseClient: SupabaseClient,
    private val sessionManager: SessionManager
) : ViewModel() {

    fun isUserLogedIn(callback:(Boolean) -> Unit){
        val refreshToken = sessionManager.getRefreshToken() ?: return callback(false)

        viewModelScope.launch {
            val userSession = supabaseClient.auth.refreshSession(refreshToken)

            sessionManager.saveSession(userSession)

            callback(true)
        }
    }
}