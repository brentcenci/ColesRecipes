package com.brentcodes.colesrecipes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil3.compose.AsyncImage

@Composable
fun RecipeCard(thumbnail: String, thumbnailAlt: String, title: String) {

    //Should fill max-width, fixed height?
    //Clickable -> Navigates to Recipe Page

    Column(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(model = thumbnail, contentDescription = thumbnailAlt, modifier = Modifier.fillMaxWidth())
        Text(text = "RECIPE", color = Color.Red)
        Text(text = title)
    }
}