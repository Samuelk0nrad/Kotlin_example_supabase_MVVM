package org.example.project.utils

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val id: Int? = null,
    val name: String,
)