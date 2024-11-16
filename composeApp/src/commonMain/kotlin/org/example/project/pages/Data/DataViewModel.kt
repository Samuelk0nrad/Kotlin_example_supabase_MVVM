package org.example.project.pages.Data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch
import org.example.project.utils.Country

class DataViewModel(
    private val supabaseClient: SupabaseClient
): ViewModel() {
    private val _countries = mutableStateListOf<Country>()
    val countries: List<Country> = _countries

    private val addCountryPopUp = mutableStateOf(false)
    val addCountryPopUpState: Boolean = addCountryPopUp.value

    fun openAddCountryPopUp() {
        addCountryPopUp.value = true
    }

    fun closeAddCountryPopUp() {
        addCountryPopUp.value = false
    }

    fun getCountries() {
        viewModelScope.launch {
            val countriesList = supabaseClient.from("countries")
                .select().decodeList<Country>()
            _countries.clear()
            _countries.addAll(countriesList)
        }
    }

    fun insertData(country: Country) {
        viewModelScope.launch {
            supabaseClient.from("countries").insert(country)
        }
    }
}