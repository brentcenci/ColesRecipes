package com.brentcodes.colesrecipes.ui.screens

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brentcodes.colesrecipes.ui.ErrorState
import com.brentcodes.colesrecipes.ui.UserEvent
import com.brentcodes.colesrecipes.ui.components.RecipeCard

@Composable
fun RecipeListView(
    viewModel: RecipeListViewModel,
    orientation: Int = 1,
    onNavigateToDetails: () -> Unit
) {

    val recipesList by viewModel.recipes
    val errorState by viewModel.errorState.collectAsState()
    val userEvent by viewModel.userEvent.collectAsState()

    LaunchedEffect(userEvent) {
        Log.d("User Event", "User Event detected")
        if (userEvent == UserEvent.NAVIGATE_TO_DETAILS){
            onNavigateToDetails()
            viewModel.resetEvent()
        }
    }

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
                            viewModel.selectRecipe(recipe = recipe, /*could pass in onNavigate here*/)
                            /*onNavigateToDetails()*/
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