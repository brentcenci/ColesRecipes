package com.brentcodes.colesrecipes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brentcodes.colesrecipes.data.Recipe
import com.brentcodes.colesrecipes.ui.theme.accentGrey
import com.brentcodes.colesrecipes.ui.theme.textGrey

@Composable
fun RecipeIngredients(modifier: Modifier = Modifier, recipe: Recipe) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Text(
            text = "Ingredients",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        recipe.ingredients.mapNotNull { it["ingredient"] }.forEach { ingredient ->
            RecipeIngredientLine(ingredient = ingredient)
        }
    }
}

@Composable
fun RecipeIngredientLine(ingredient: String) {
    Row(
        modifier = Modifier.padding(
            horizontal = 5.dp,
            vertical = 5.dp
        ),
    ) {
        Text(
            text = ">",
            modifier = Modifier.weight(0.05f),
            color = MaterialTheme.colorScheme.textGrey,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = ingredient,
            modifier = Modifier.weight(0.95f),
            lineHeight = 18.sp,
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.textGrey,
            fontWeight = FontWeight.Medium
        )
    }
}