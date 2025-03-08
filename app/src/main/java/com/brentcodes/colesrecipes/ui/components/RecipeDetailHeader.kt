package com.brentcodes.colesrecipes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RecipeDetailHeader(modifier: Modifier = Modifier, title: String, description: String) {
    Column(modifier = modifier) {
        Text(
            text = title,
            textAlign = MaterialTheme.typography.headlineLarge.textAlign,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = MaterialTheme.typography.headlineLarge.fontWeight,
            lineHeight = MaterialTheme.typography.headlineLarge.lineHeight,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = description,
            textAlign = MaterialTheme.typography.bodyLarge.textAlign,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = MaterialTheme.typography.bodyLarge.fontWeight
        )
    }

}