package com.brentcodes.colesrecipes.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponse(
    val recipes: List<Recipe>
)
