package org.example.project

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import kotlinx.coroutines.launch
import org.example.project.authentication.data.SessionManager

class AppViewModel(
    private val supabaseClient: SupabaseClient
) : ViewModel() {
    val sessionStatus = supabaseClient.auth.sessionStatus
}