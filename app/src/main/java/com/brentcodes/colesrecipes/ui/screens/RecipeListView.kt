package com.brentcodes.colesrecipes.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.brentcodes.colesrecipes.ui.components.RecipeCard

@Composable
fun RecipeListView(modifier: Modifier = Modifier, navController: NavController, viewModel: RecipeViewModel, orientation: Int = 1) {

    //Vertical Grid of 2-columns (when portrait - what about landscape?)
    //Display list of RecipeCards
    //This screen needs access to the data list, and then calls an items on the data and translates it into RecipeCards
    val recipesList by viewModel.recipes.collectAsState()
    val columns = when (orientation) {
        Configuration.ORIENTATION_PORTRAIT -> 1
        else -> 2
    }

    LazyVerticalGrid(
        modifier = Modifier.padding(vertical = 20.dp),
        columns = GridCells.Fixed(columns),
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        recipesList?.let { response ->
            items(response.recipes) { recipe ->
                /*Text(it.dynamicTitle)*/
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