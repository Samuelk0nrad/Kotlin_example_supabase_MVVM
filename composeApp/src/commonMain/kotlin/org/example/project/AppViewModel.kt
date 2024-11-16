package org.example.project

import androidx.lifecycle.ViewModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth

class AppViewModel(
    supabaseClient: SupabaseClient
) : ViewModel() {
    val sessionStatus = supabaseClient.auth.sessionStatus
}