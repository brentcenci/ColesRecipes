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
            textAlign = TextAlign.Center,
            fontSize = 48.sp,
            fontWeight = FontWeight.Black,
            lineHeight = TextUnit(48f, type = TextUnitType.Sp),
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Center,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = MaterialTheme.typography.bodyLarge.fontWeight
        )
    }

}