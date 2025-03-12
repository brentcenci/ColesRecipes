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
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: ColesRepository
) : ViewModel() {

    private val _errorState: MutableStateFlow<ErrorState> = MutableStateFlow(ErrorState.EMPTY)
    val errorState = _errorState.stateIn(scope = viewModelScope, SharingStarted.Eagerly, ErrorState.EMPTY)

    private val _userEvent: MutableStateFlow<UserEvent> = MutableStateFlow(UserEvent.NONE)
    val userEvent = _userEvent.stateIn(scope = viewModelScope, SharingStarted.Eagerly, UserEvent.NONE)

    val recipes = repository.recipes.stateIn(scope = viewModelScope, SharingStarted.Eagerly, null)

    init {
        repository.recipes.map { response ->
            if (response != null) {
                _errorState.value = ErrorState.DATA
            } else {
                _errorState.value = ErrorState.ERROR
            }
        }.stateIn(scope = viewModelScope, SharingStarted.Eagerly, ErrorState.LOADING)
    }

    fun selectRecipe(recipe: Recipe) {
        repository.selectRecipe(recipe)
        _userEvent.value = UserEvent.NAVIGATE_TO_DETAILS
    }

    fun resetEvent() {
        _userEvent.value = UserEvent.NONE
    }
}