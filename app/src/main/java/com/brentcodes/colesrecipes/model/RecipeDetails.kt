package com.brentcodes.colesrecipes.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeDetails(
    val amountLabel: String,
    val amountNumber: Int,
    val prepLabel: String,
    val prepTime: String,
    // Currently not doing anything with prepNote - missing from design documents in brief
    val prepNote: String? = null,
    val cookingLabel: String,
    val cookingTime: String,
    val cookTimeAsMinutes: Int,
    val prepTimeAsMinutes: Int
)
