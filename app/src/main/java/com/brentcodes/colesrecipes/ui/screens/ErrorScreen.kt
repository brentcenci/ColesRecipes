package com.brentcodes.colesrecipes.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ErrorScreen(modifier: Modifier = Modifier, errorType: String, errorMessage: String) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = errorType,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = MaterialTheme.typography.headlineLarge.fontWeight,
                textAlign = MaterialTheme.typography.headlineLarge.textAlign,
                lineHeight = MaterialTheme.typography.headlineLarge.lineHeight
                )
            Text(
                text = errorMessage,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
                textAlign = MaterialTheme.typography.bodyLarge.textAlign,
            )
        }
    }
}