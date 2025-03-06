package com.brentcodes.colesrecipes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.brentcodes.colesrecipes.data.Recipe
import com.brentcodes.colesrecipes.data.RecipeStats

@Composable
fun RecipeStatsCard(modifier: Modifier = Modifier, recipeStats: RecipeStats) {
    Column {
        HorizontalDivider(thickness = 2.dp)
        Row {
            RecipeStatSection(
                modifier = Modifier.weight(1f),
                topText = recipeStats.amountLabel,
                bottomText = recipeStats.amountNumber.toString()
            )
            VerticalDivider(thickness = 1.dp)
            RecipeStatSection(
                modifier = Modifier.weight(1f),
                topText = recipeStats.prepLabel,
                bottomText = recipeStats.prepTime
            )
            VerticalDivider(thickness = 1.dp)
            RecipeStatSection(
                modifier = Modifier.weight(1f),
                topText = recipeStats.cookingLabel,
                bottomText = recipeStats.cookingTime
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