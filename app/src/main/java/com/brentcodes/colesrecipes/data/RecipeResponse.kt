package com.brentcodes.colesrecipes.data

import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponse(
    val recipes: List<Recipe>
)
