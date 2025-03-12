package com.brentcodes.colesrecipes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.brentcodes.colesrecipes.data.ColesRepository
import com.brentcodes.colesrecipes.data.JsonReader
import com.brentcodes.colesrecipes.model.Recipe
import com.brentcodes.colesrecipes.model.RecipeDetails
import com.brentcodes.colesrecipes.model.RecipeResponse

class FakeColesRepository(private val jsonFileReader: JsonReader) : ColesRepository{
    private val _recipes = mutableStateOf<RecipeResponse?>(null)
    override val recipes : State<RecipeResponse?> = _recipes

    private val _selectedRecipe = mutableStateOf<Recipe?>(null)
    override val selectedRecipe : State<Recipe?> = _selectedRecipe

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

    override fun selectRecipe(recipe: Recipe) {
        _selectedRecipe.value = recipe
    }
}