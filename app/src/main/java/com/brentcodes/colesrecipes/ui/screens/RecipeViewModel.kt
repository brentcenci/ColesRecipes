package com.brentcodes.colesrecipes.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brentcodes.colesrecipes.data.Recipe
import com.brentcodes.colesrecipes.data.RecipeResponse
import com.brentcodes.colesrecipes.data.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RecipeViewModel(private val repository: Repository) : ViewModel() {

    private val _selectedRecipe: MutableStateFlow<Recipe?> = MutableStateFlow(null)
    val selectedRecipe = _selectedRecipe.stateIn(scope = viewModelScope, SharingStarted.Lazily, null)

    private val _recipes: MutableStateFlow<RecipeResponse?> = MutableStateFlow(null)
    val recipes = _recipes.stateIn(scope = viewModelScope, SharingStarted.Lazily, null)

    init {
        viewModelScope.launch {
            _recipes.value = repository.getData()
            println(recipes.value?.recipes)
        }
    }

    fun selectRecipe(recipe: Recipe) {
        _selectedRecipe.value = recipe
    }
}