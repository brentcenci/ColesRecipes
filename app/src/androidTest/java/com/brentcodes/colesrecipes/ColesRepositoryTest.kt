package com.brentcodes.colesrecipes

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.brentcodes.colesrecipes.data.ColesRepository
import com.brentcodes.colesrecipes.data.ColesRepositoryImpl
import com.brentcodes.colesrecipes.data.JsonFileReader
import com.brentcodes.colesrecipes.data.JsonReader
import com.brentcodes.colesrecipes.model.Recipe
import com.brentcodes.colesrecipes.model.RecipeDetails
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ColesRepositoryTest {
    private lateinit var context: Context
    private lateinit var jsonFileReader : JsonReader
    private lateinit var repository: ColesRepository
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
        context = ApplicationProvider.getApplicationContext()
        jsonFileReader = JsonFileReader
        repository = ColesRepositoryImpl(context, jsonFileReader)
    }

    @Test
    fun checkGetDataOnInit() {
        val recipes = repository.recipes.value
        assertNotNull(recipes)
    }

    @Test
    fun checkSetSelectedRecipe() {
        assertNull(repository.selectedRecipe.value)
        repository.selectRecipe(testRecipe)
        assertNotNull(repository.selectedRecipe.value)
        assertEquals(testRecipe, repository.selectedRecipe.value)
    }
}