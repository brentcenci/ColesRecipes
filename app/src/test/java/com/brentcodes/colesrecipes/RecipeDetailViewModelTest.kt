package com.brentcodes.colesrecipes

import com.brentcodes.colesrecipes.data.ColesRepository
import com.brentcodes.colesrecipes.data.JsonFileReader
import com.brentcodes.colesrecipes.model.Recipe
import com.brentcodes.colesrecipes.model.RecipeDetails
import com.brentcodes.colesrecipes.ui.screens.RecipeDetailViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RecipeDetailViewModelTest {

    private lateinit var testRepository: ColesRepository
    private lateinit var viewModel: RecipeDetailViewModel
    private val testRecipe = Recipe(
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
    )

    @Before
    fun setup() {
        testRepository = FakeColesRepository(JsonFileReader)
        viewModel = RecipeDetailViewModel(testRepository)
    }

    @Test
    fun getSelectedRecipe() {
        testRepository.selectRecipe(recipe = testRecipe)
        assertEquals(testRecipe, viewModel.selectedRecipe.value)
    }
}