package com.brentcodes.colesrecipes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.brentcodes.colesrecipes.data.Repository
import com.brentcodes.colesrecipes.ui.components.RecipeCard

@Composable
fun RecipeListView(modifier: Modifier = Modifier, navController: NavController) {

    //Vertical Grid of 2-columns (when portrait - what about landscape?)
    //Display list of RecipeCards
    //This screen needs access to the data list, and then calls an items on the data and translates it into RecipeCards
    val repo = Repository(context = LocalContext.current)
    val data = remember { repo.getData() }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        data?.let { response ->
            items(response.recipes) { recipe ->
                /*Text(it.dynamicTitle)*/
                RecipeCard(
                    thumbnail = "https://coles.com.au/" + recipe.dynamicThumbnail,
                    thumbnailAlt = recipe.dynamicThumbnailAlt,
                    title = recipe.dynamicTitle
                )
            }
        }

    }
}