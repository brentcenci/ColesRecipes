package com.brentcodes.colesrecipes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.brentcodes.colesrecipes.data.Recipe
import com.brentcodes.colesrecipes.ui.components.RecipeIngredients
import com.brentcodes.colesrecipes.ui.components.RecipeStatsCard

@Composable
fun RecipeDetailView(modifier: Modifier = Modifier, navController: NavController, recipe: Recipe) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        //Recipe Title
        Text(text = recipe.dynamicTitle)
        //Recipe Description
        Text(text = recipe.dynamicDescription)
        //Image
        AsyncImage(
            model = "https://coles.com.au/" + recipe.dynamicThumbnail,
            contentDescription = recipe.dynamicThumbnailAlt,
            modifier = Modifier.fillMaxWidth()
        )
        //Stats info (Serves, Prep time, Cooking time)
        RecipeStatsCard(recipeStats = recipe.recipeStats)
        //Ingredients
        RecipeIngredients(recipe = recipe)
    }
}