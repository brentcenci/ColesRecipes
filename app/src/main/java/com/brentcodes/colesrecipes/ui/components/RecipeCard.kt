package com.brentcodes.colesrecipes.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.brentcodes.colesrecipes.R
import com.brentcodes.colesrecipes.ui.theme.colesRed

@Composable
fun RecipeCard(modifier: Modifier = Modifier, thumbnail: String, thumbnailAlt: String, title: String) {

    //Should fill max-width, fixed height?
    //Clickable -> Navigates to Recipe Page

    Column(modifier = modifier.fillMaxWidth().padding(10.dp)) {
        Image(
            painter = rememberAsyncImagePainter(
                model = thumbnail,
                error = painterResource(R.drawable.coles_error_image),
                onError = {
                    Log.e("Image Loading", "Error loading an image, check network connectivity")
                },
                placeholder = painterResource(R.drawable.coles_loading_image),
            ),
            contentDescription = thumbnailAlt,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = "RECIPE",
            color = MaterialTheme.colorScheme.colesRed,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
            textAlign = MaterialTheme.typography.titleMedium.textAlign
        )
        Text(
            text = title,
            fontSize = MaterialTheme.typography.titleSmall.fontSize,
            fontWeight = MaterialTheme.typography.titleSmall.fontWeight,
            textAlign = MaterialTheme.typography.titleSmall.textAlign
        )
    }
}