package com.brentcodes.colesrecipes

import com.brentcodes.colesrecipes.data.ColesRepository
import com.brentcodes.colesrecipes.data.JsonFileReader
import com.brentcodes.colesrecipes.model.Recipe
import com.brentcodes.colesrecipes.model.RecipeDetails
import com.brentcodes.colesrecipes.ui.screens.RecipeDetailViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.DisplayName

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

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    @DisplayName("Given the ViewModel is loaded, when you select a recipe in the repository, then the ViewModel should reflect the same recipe")
    fun getSelectedRecipe() = runTest {
        testRepository.selectRecipe(recipe = testRecipe)
        advanceUntilIdle()
        assertEquals(testRecipe, viewModel.selectedRecipe.value)
    }
}