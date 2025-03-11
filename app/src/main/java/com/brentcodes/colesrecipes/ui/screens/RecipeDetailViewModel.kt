package com.brentcodes.colesrecipes.ui.screens

import androidx.lifecycle.ViewModel
import com.brentcodes.colesrecipes.data.ColesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val repository: ColesRepository
) : ViewModel() {

    val selectedRecipe = repository.selectedRecipe

}