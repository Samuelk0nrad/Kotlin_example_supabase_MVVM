package org.example.project

import org.koin.compose.viewmodel.dsl.viewModelOf
import org.example.project.authentication.AuthenticationViewModel
import org.example.project.pages.data.DataViewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

expect val platformModule: Module

val sharedModule = module {
    single {
        createSupabaseClient(
            supabaseUrl = "https://kfvqfwajrrrveegoihrc.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImtmdnFmd2FqcnJydmVlZ29paHJjIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzA3MTQ0MTYsImV4cCI6MjA0NjI5MDQxNn0.D-TC5JTneStsuCHt8cqvvHk8IeeeoULdVgqNrJm__Jo"
        ) {
            install(Postgrest)
            install(Auth)
        }
    }

    viewModelOf(::AppViewModel)

    viewModelOf(::AuthenticationViewModel)

    viewModelOf(::DataViewModel)
}