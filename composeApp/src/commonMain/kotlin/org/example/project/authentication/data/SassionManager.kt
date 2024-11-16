package org.example.project.authentication.data

import com.russhwolf.settings.Settings
import io.github.jan.supabase.auth.user.UserSession

class SessionManager(private val settings: Settings) {

    // Save session tokens
    fun saveSession(session: UserSession) {
        settings.putString("access_token", session.accessToken)
        settings.putString("refresh_token", session.refreshToken)
    }

    // Retrieve access token
    fun getAccessToken(): String? {
        return settings.getStringOrNull("access_token")
    }

    // Retrieve refresh token
    fun getRefreshToken(): String? {
        return settings.getStringOrNull("refresh_token")
    }

    // Clear session data
    fun clearSession() {
        settings.remove("access_token")
        settings.remove("refresh_token")
    }
}
