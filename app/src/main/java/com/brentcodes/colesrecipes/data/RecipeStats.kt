package com.brentcodes.colesrecipes.data

import kotlinx.serialization.Serializable

@Serializable
data class RecipeStats(
    val amountLabel: String,
    val amountNumber: Int,
    val prepLabel: String,
    val prepTime: String,
    val prepNote: String? = null,
    val cookingLabel: String,
    val cookingTime: String,
    val cookTimeAsMinutes: Int,
    val prepTimeAsMinutes: Int
)
