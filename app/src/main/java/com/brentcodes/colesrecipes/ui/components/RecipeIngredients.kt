package com.brentcodes.colesrecipes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brentcodes.colesrecipes.data.Recipe

@Composable
fun RecipeIngredients(modifier: Modifier = Modifier, recipe: Recipe) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = "Ingredients")
        recipe.ingredients.mapNotNull { it["ingredient"] }.forEach { step ->
            Text(text = step)
        }
    }
}