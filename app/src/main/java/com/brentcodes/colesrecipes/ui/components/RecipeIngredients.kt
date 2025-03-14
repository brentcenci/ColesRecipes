package com.brentcodes.colesrecipes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.brentcodes.colesrecipes.model.Recipe
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
            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            textAlign = MaterialTheme.typography.titleLarge.textAlign,
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
            modifier = Modifier
                .weight(0.05f)
                .semantics {
                    /*
                    * Setting this Chevron to invisible to the user so that
                    * If accessibility features are active, it is not
                    * read out to the user.
                    */
                    invisibleToUser()
                           },
            lineHeight = MaterialTheme.typography.bodySmall.lineHeight,
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            color = MaterialTheme.colorScheme.textGrey,
            fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
            textAlign = MaterialTheme.typography.bodySmall.textAlign
        )
        Text(
            text = ingredient,
            modifier = Modifier.weight(0.95f),
            lineHeight = MaterialTheme.typography.bodySmall.lineHeight,
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            color = MaterialTheme.colorScheme.textGrey,
            fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
            textAlign = MaterialTheme.typography.bodySmall.textAlign
        )
    }
}