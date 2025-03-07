package com.brentcodes.colesrecipes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brentcodes.colesrecipes.data.RecipeDetails

@Composable
fun RecipeStatsCard(modifier: Modifier = Modifier, recipeDetails: RecipeDetails) {
    Column {
        HorizontalDivider(thickness = 2.dp)
        Row {
            RecipeStatSection(
                modifier = Modifier.weight(1f),
                topText = recipeDetails.amountLabel,
                bottomText = recipeDetails.amountNumber.toString()
            )
            VerticalDivider(thickness = 1.dp)
            RecipeStatSection(
                modifier = Modifier.weight(1f),
                topText = recipeDetails.prepLabel,
                bottomText = recipeDetails.prepTime
            )
            VerticalDivider(thickness = 1.dp)
            RecipeStatSection(
                modifier = Modifier.weight(1f),
                topText = recipeDetails.cookingLabel,
                bottomText = recipeDetails.cookingTime
            )
        }
    }
}

@Composable
fun RecipeStatSection(modifier: Modifier = Modifier, topText: String, bottomText: String) {
    Column(modifier = modifier) {
        Text(text = topText)
        Text(text = bottomText)
    }
}