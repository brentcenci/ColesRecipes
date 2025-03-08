package com.brentcodes.colesrecipes.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.brentcodes.colesrecipes.ui.ErrorState
import com.brentcodes.colesrecipes.ui.components.RecipeCard
import kotlinx.serialization.internal.throwMissingFieldException

@Composable
fun RecipeListView(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: RecipeViewModel,
    orientation: Int = 1) {

    val recipesList by viewModel.recipes.collectAsState()
    val errorState by viewModel.errorState.collectAsState()
    val columns = when (orientation) {
        Configuration.ORIENTATION_PORTRAIT -> 1
        else -> 2
    }
    if (errorState == ErrorState.ERROR) {
        ErrorScreen(
            errorType = "Error Loading Data",
            errorMessage = "Unable to load data. Please try launching the application again. If error persists, review logs."
        )
    } else {
        LazyVerticalGrid(
            modifier = Modifier,
            columns = GridCells.Fixed(columns),
            contentPadding = PaddingValues(horizontal = 5.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            recipesList?.let { response ->
                items(response.recipes) { recipe ->
                    RecipeCard(
                        modifier = Modifier.clickable {
                            viewModel.selectRecipe(recipe = recipe)
                            navController.navigate(route = "details")
                        },
                        thumbnail = "https://coles.com.au/" + recipe.dynamicThumbnail,
                        thumbnailAlt = recipe.dynamicThumbnailAlt,
                        title = recipe.dynamicTitle
                    )
                }
            }
        }
    }

}