package com.brentcodes.colesrecipes.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brentcodes.colesrecipes.data.ColesRepository
import com.brentcodes.colesrecipes.ui.ErrorState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val repository: ColesRepository
) : ViewModel() {

    val selectedRecipe = repository.selectedRecipe.stateIn(scope = viewModelScope, SharingStarted.Eagerly, null)

}