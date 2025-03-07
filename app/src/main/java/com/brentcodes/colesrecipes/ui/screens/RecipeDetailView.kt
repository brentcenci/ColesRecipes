package com.brentcodes.colesrecipes.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.brentcodes.colesrecipes.ui.components.RecipeDetailHeader
import com.brentcodes.colesrecipes.ui.components.RecipeIngredients
import com.brentcodes.colesrecipes.ui.components.RecipeStatsCard

@Composable
fun RecipeDetailView(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: RecipeViewModel
) {

    val selectedRecipe by viewModel.selectedRecipe.collectAsState()

    selectedRecipe?.let { recipe ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            //Recipe Title
            item {
                RecipeDetailHeader(
                    modifier = Modifier.padding(horizontal = 32.dp),
                    title = recipe.dynamicTitle,
                    description = recipe.dynamicDescription
                )
            }
            //Image
            item {
                AsyncImage(
                    model = "https://coles.com.au/" + recipe.dynamicThumbnail,
                    contentDescription = recipe.dynamicThumbnailAlt,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            //Stats info (Serves, Prep time, Cooking time)
            item {
                RecipeStatsCard(recipeDetails = recipe.recipeDetails, modifier = Modifier.fillMaxWidth().height(80.dp))
            }
            //Ingredients
            item {
                RecipeIngredients(recipe = recipe)
            }
        }
    }
}