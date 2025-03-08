package com.brentcodes.colesrecipes.ui.components

import android.content.res.Resources
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brentcodes.colesrecipes.data.RecipeDetails
import com.brentcodes.colesrecipes.ui.theme.ColesRecipesTheme
import com.brentcodes.colesrecipes.ui.theme.accentGrey
import com.brentcodes.colesrecipes.ui.theme.textGrey

@Composable
fun RecipeStatsCard(modifier: Modifier = Modifier, recipeDetails: RecipeDetails) {
    Column(modifier = modifier) {
        HorizontalDivider(thickness = 3.dp, color = MaterialTheme.colorScheme.accentGrey)
        Row(
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            RecipeStatSection(
                modifier = Modifier.weight(1f),
                topText = recipeDetails.amountLabel,
                bottomText = recipeDetails.amountNumber.toString()
            )
            VerticalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.accentGrey)
            RecipeStatSection(
                modifier = Modifier.weight(1f),
                topText = recipeDetails.prepLabel,
                bottomText = recipeDetails.prepTime
            )
            VerticalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.accentGrey)
            RecipeStatSection(
                modifier = Modifier.weight(1f),
                topText = recipeDetails.cookingLabel,
                bottomText = recipeDetails.cookingTime
            )
        }
        HorizontalDivider(thickness = 3.dp, color = MaterialTheme.colorScheme.accentGrey)
    }
}

@Composable
fun RecipeStatSection(modifier: Modifier = Modifier, topText: String, bottomText: String) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = topText,
            fontSize = MaterialTheme.typography.labelMedium.fontSize,
            fontWeight = MaterialTheme.typography.labelMedium.fontWeight,
            textAlign = MaterialTheme.typography.labelMedium.textAlign,
            color = MaterialTheme.colorScheme.textGrey
        )
        Text(
            text = bottomText,
            fontSize = MaterialTheme.typography.labelLarge.fontSize,
            fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
            textAlign = MaterialTheme.typography.labelLarge.textAlign
        )
    }
}