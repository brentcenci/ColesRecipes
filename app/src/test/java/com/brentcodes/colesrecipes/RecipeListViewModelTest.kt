package com.brentcodes.colesrecipes

import com.brentcodes.colesrecipes.data.ColesRepository
import com.brentcodes.colesrecipes.data.JsonFileReader
import com.brentcodes.colesrecipes.model.Recipe
import com.brentcodes.colesrecipes.model.RecipeDetails
import com.brentcodes.colesrecipes.ui.ErrorState
import com.brentcodes.colesrecipes.ui.UserEvent
import com.brentcodes.colesrecipes.ui.screens.RecipeListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RecipeListViewModelTest {

    private lateinit var testRepository: ColesRepository
    private lateinit var viewModel: RecipeListViewModel
    private val testDispatcher = StandardTestDispatcher()
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

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        testRepository = FakeColesRepository(JsonFileReader)
        viewModel = RecipeListViewModel(testRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun clearDispatcher() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getErrorState()  = runTest {
        advanceUntilIdle()
        assertEquals(ErrorState.DATA, viewModel.errorState.value)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getUserEvent() = runTest {
        advanceUntilIdle()
        assertEquals(UserEvent.NONE, viewModel.userEvent.value)
    }

    @Test
    fun getRecipes() {
        viewModel.getData()
        assertEquals(viewModel.recipes.value, testRepository.recipes.value)
    }

    @Test
    fun selectRecipe() {
        viewModel.selectRecipe(recipe = testRecipe)
        assertEquals(testRecipe, testRepository.selectedRecipe.value)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun resetEvent() = runTest {
        viewModel.selectRecipe(recipe = testRecipe)
        advanceUntilIdle()
        assertEquals(UserEvent.NAVIGATE_TO_DETAILS, viewModel.userEvent.value)
        viewModel.resetEvent()
        advanceUntilIdle()
        assertEquals(UserEvent.NONE, viewModel.userEvent.value)
    }
}