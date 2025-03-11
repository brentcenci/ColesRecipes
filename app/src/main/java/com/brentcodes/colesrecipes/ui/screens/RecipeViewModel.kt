package com.brentcodes.colesrecipes.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brentcodes.colesrecipes.data.ColesRepository
import com.brentcodes.colesrecipes.data.Recipe
import com.brentcodes.colesrecipes.data.RecipeResponse
import com.brentcodes.colesrecipes.ui.ErrorState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val repository: ColesRepository) : ViewModel() {

    private val _selectedRecipe: MutableStateFlow<Recipe?> = MutableStateFlow(null)
    val selectedRecipe = _selectedRecipe.stateIn(scope = viewModelScope, SharingStarted.Lazily, null)

    private val _recipes: MutableStateFlow<RecipeResponse?> = MutableStateFlow(null)
    val recipes = _recipes.stateIn(scope = viewModelScope, SharingStarted.Lazily, null)

    private val _errorState: MutableStateFlow<ErrorState> = MutableStateFlow(ErrorState.EMPTY)
    val errorState = _errorState.stateIn(scope = viewModelScope, SharingStarted.Lazily, ErrorState.EMPTY)

    init {
        _errorState.value = ErrorState.LOADING
        viewModelScope.launch {
            _recipes.value = repository.getData()
            if (_recipes.value != null) {
                _errorState.value = ErrorState.DATA
            } else {
                _errorState.value = ErrorState.ERROR
            }
        }
    }

    fun selectRecipe(recipe: Recipe) {
        _selectedRecipe.value = recipe
    }
}