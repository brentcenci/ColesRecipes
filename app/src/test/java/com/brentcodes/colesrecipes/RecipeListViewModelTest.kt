package com.brentcodes.colesrecipes

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
import org.junit.jupiter.api.DisplayName

class RecipeListViewModelTest {

    private lateinit var testRepository: FakeColesRepository
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
        testRepository.getData()
        viewModel = RecipeListViewModel(testRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun clearDispatcher() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    @DisplayName("Given the ViewModel is loaded, when the user has not interacted, then the errorState should be ErrorState.DATA")
    fun getErrorState()  = runTest {
        advanceUntilIdle()
        assertEquals(ErrorState.DATA, viewModel.errorState.value)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    @DisplayName("Given ViewModel launched, when user has not interacted, then userEvent should be UserEvent.NONE")
    fun getUserEvent() = runTest {
        advanceUntilIdle()
        assertEquals(UserEvent.NONE, viewModel.userEvent.value)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    @DisplayName("Given ViewModel launched, when data is loaded, then recipes should contain data from repository")
    fun getRecipes() = runTest {
        /*viewModel.getData()*/
        advanceUntilIdle()
        assertEquals(viewModel.recipes.value, testRepository.recipes.value)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    @DisplayName("Given the ViewModel is loaded, when you set the response stored in the repository to null, then the ViewModel errorState should be ErrorState.ERROR")
    fun getRecipeErrorState() = runTest {
        testRepository.setResponseAsNull()
        advanceUntilIdle()
        assertEquals(ErrorState.ERROR, viewModel.errorState.value)
    }

    @Test
    @DisplayName("Given the ViewModel is loaded, when you select a recipe, then the repository should be updated with the same recipe")
    fun selectRecipe() {
        viewModel.selectRecipe(recipe = testRecipe)
        assertEquals(testRecipe, testRepository.selectedRecipe.value)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    @DisplayName("Given the ViewModel is loaded, when you select a recipe, then the UserEvent state should update to NAVIGATE_TO_DETAILS and when you use resetEvent, the UserEvent state should be reset to NONE")
    fun resetEvent() = runTest {
        viewModel.selectRecipe(recipe = testRecipe)
        advanceUntilIdle()
        assertEquals(UserEvent.NAVIGATE_TO_DETAILS, viewModel.userEvent.value)
        viewModel.resetEvent()
        advanceUntilIdle()
        assertEquals(UserEvent.NONE, viewModel.userEvent.value)
    }
}