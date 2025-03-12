package com.brentcodes.colesrecipes.data

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.brentcodes.colesrecipes.model.Recipe
import com.brentcodes.colesrecipes.model.RecipeResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

interface ColesRepository {
    val recipes: StateFlow<RecipeResponse?>
    val selectedRecipe: StateFlow<Recipe?>
    fun getData()
    fun selectRecipe(recipe: Recipe)
}

/*
* Storing states here rather than passing via Compose Navigation.
*
* This is due to the dataset not having unique IDs to reference the data,
* and trying to perform the best practices of not passing complex objects (URL)
* (e.g. a Recipe() object).
* As the Repository is a Singleton (via Hilt), the states are
* maintained across the application and can be served to / accessed from
* the ViewModels.
*
* In theory I would prefer to use Compose Navigation and pass a reference
* to the recipe selected via unique ID if this were available.
* */
class ColesRepositoryImpl @Inject constructor(private val context: Context, private val jsonFileReader: JsonReader) : ColesRepository {
    private val _recipes = MutableStateFlow<RecipeResponse?>(null)
    override val recipes : StateFlow<RecipeResponse?> = _recipes.asStateFlow()

    private val _selectedRecipe = MutableStateFlow<Recipe?>(null)
    override val selectedRecipe : StateFlow<Recipe?> = _selectedRecipe.asStateFlow()

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