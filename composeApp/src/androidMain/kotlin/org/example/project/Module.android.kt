package org.example.project

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule: Module = module {
    single {
        val sharedPreferences = androidContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        SharedPreferencesSettings(sharedPreferences)
    }.bind(Settings::class)
}