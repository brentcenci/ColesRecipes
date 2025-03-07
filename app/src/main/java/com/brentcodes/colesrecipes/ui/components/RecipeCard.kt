package com.brentcodes.colesrecipes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun RecipeCard(modifier: Modifier = Modifier, thumbnail: String, thumbnailAlt: String, title: String) {

    //Should fill max-width, fixed height?
    //Clickable -> Navigates to Recipe Page

    Column(modifier = modifier.fillMaxWidth().padding(10.dp)) {
        AsyncImage(
            model = thumbnail,
            contentDescription = thumbnailAlt,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = "RECIPE",
            color = Color.Red,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}