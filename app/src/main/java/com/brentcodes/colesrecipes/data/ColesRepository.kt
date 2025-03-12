package com.brentcodes.colesrecipes.data

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.brentcodes.colesrecipes.model.Recipe
import com.brentcodes.colesrecipes.model.RecipeResponse
import javax.inject.Inject

interface ColesRepository {
    val recipes: State<RecipeResponse?>
    val selectedRecipe: State<Recipe?>
    fun getData()
    fun selectRecipe(recipe: Recipe)
}

class ColesRepositoryImpl @Inject constructor(private val context: Context, private val jsonFileReader: JsonReader) : ColesRepository {
    private val _recipes = mutableStateOf<RecipeResponse?>(null)
    override val recipes : State<RecipeResponse?> = _recipes

    private val _selectedRecipe = mutableStateOf<Recipe?>(null)
    override val selectedRecipe : State<Recipe?> = _selectedRecipe

    init {
        getData()
    }

    override fun getData() {
        _recipes.value = jsonFileReader.parseJson(context, "recipesSample.json")
    }

    override fun selectRecipe(recipe: Recipe) {
        _selectedRecipe.value = recipe
    }

}