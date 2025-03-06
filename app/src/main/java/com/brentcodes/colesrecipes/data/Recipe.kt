package com.brentcodes.colesrecipes.data

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val dynamicTitle: String,
    val dynamicDescription: String,
    val dynamicThumbnail: String,
    val dynamicThumbnailAlt: String,
    val recipeDetails: RecipeDetails,
    val ingredients: List<Map<String, String>>
)
