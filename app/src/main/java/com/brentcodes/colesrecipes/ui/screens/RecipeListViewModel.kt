package com.brentcodes.colesrecipes.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brentcodes.colesrecipes.data.ColesRepository
import com.brentcodes.colesrecipes.model.Recipe
import com.brentcodes.colesrecipes.ui.ErrorState
import com.brentcodes.colesrecipes.ui.UserEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: ColesRepository
) : ViewModel() {

    private val _errorState: MutableStateFlow<ErrorState> = MutableStateFlow(ErrorState.EMPTY)
    val errorState = _errorState.stateIn(scope = viewModelScope, SharingStarted.Lazily, ErrorState.EMPTY)

    private val _userEvent: MutableStateFlow<UserEvent> = MutableStateFlow(UserEvent.NONE)
    val userEvent = _userEvent.stateIn(scope = viewModelScope, SharingStarted.Lazily, UserEvent.NONE)

    val recipes = repository.recipes

    init {
        _errorState.value = ErrorState.LOADING
        viewModelScope.launch {
            getData()
            if (repository.recipes.value != null) {
                _errorState.value = ErrorState.DATA
            } else {
                _errorState.value = ErrorState.ERROR
            }
        }
    }

    fun selectRecipe(recipe: Recipe) {
        repository.selectRecipe(recipe)
        _userEvent.value = UserEvent.NAVIGATE_TO_DETAILS
    }

    private fun getData() {
        repository.getData()
    }

    fun resetEvent() {
        _userEvent.value = UserEvent.NONE
    }
}