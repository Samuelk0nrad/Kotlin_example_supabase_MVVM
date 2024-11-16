package org.example.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.*
import org.example.project.utils.Country


@Composable
@Preview
fun App() {
    MaterialTheme {
       Navigation()
    }
}

// In your commonMain source set
expect fun printLog(tag: String, message: String)