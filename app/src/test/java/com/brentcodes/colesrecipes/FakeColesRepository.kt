package com.brentcodes.colesrecipes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.brentcodes.colesrecipes.data.ColesRepository
import com.brentcodes.colesrecipes.data.JsonReader
import com.brentcodes.colesrecipes.model.Recipe
import com.brentcodes.colesrecipes.model.RecipeDetails
import com.brentcodes.colesrecipes.model.RecipeResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FakeColesRepository(private val jsonFileReader: JsonReader) : ColesRepository{
    private val _recipes = MutableStateFlow<RecipeResponse?>(null)
    override val recipes : StateFlow<RecipeResponse?> = _recipes.asStateFlow()

    private val _selectedRecipe = MutableStateFlow<Recipe?>(null)
    override val selectedRecipe : StateFlow<Recipe?> = _selectedRecipe.asStateFlow()

    private val testRecipeResponse = RecipeResponse(
        recipes = listOf(
            Recipe(
                dynamicTitle = "Recipe A",
                dynamicDescription = "Recipe A Description",
                dynamicThumbnail = "Recipe A URL",
                dynamicThumbnailAlt = "Image of Recipe A",
                recipeDetails = RecipeDetails(
                    amountLabel = "Serves",
                    amountNumber = 2,
                    prepLabel = "Prep",
                    prepTime = "10m",
                    cookingLabel = "Cooking",
                    cookingTime = "10m",
                    prepTimeAsMinutes = 10,
                    cookTimeAsMinutes = 10,
                ),
                ingredients = listOf(
                    mapOf(Pair("ingredient", "ingredient 1"), Pair("ingredient", "ingredient 2"))
                )
            ),
            Recipe(
                dynamicTitle = "Recipe B",
                dynamicDescription = "Recipe B Description",
                dynamicThumbnail = "Recipe B URL",
                dynamicThumbnailAlt = "Image of Recipe B",
                recipeDetails = RecipeDetails(
                    amountLabel = "Serves",
                    amountNumber = 4,
                    prepLabel = "Prep",
                    prepTime = "15m",
                    cookingLabel = "Cooking",
                    cookingTime = "15m",
                    prepTimeAsMinutes = 15,
                    cookTimeAsMinutes = 15,
                ),
                ingredients = listOf(
                    mapOf(Pair("ingredient", "ingredient 3"), Pair("ingredient", "ingredient 4"))
                )
            )
        )
    )
    override fun getData() {
        _recipes.value = testRecipeResponse
    }

    fun setResponseAsNull() {
        _recipes.value = null
    }

    override fun selectRecipe(recipe: Recipe) {
        _selectedRecipe.value = recipe
    }
}