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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.brentcodes.colesrecipes.R
import com.brentcodes.colesrecipes.ui.theme.colesRed

@Composable
fun RecipeCard(modifier: Modifier = Modifier, thumbnail: String, thumbnailAlt: String, title: String) {

    Column(modifier = modifier
        .fillMaxWidth()
        .padding(10.dp)
        .semantics {
            /*
            * Setting the content description and the role of the overall Column of the Card,
            * rather than relying on the descriptions of each of its children.
            * In this way, I can control what is read out via accessibility features,
            * and ensure a better end user experience.
            * */
            contentDescription = "A recipe titled $title with an image of $thumbnailAlt"
            role = Role.Button
        }
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(
                    model = thumbnail,
                    error = painterResource(R.drawable.coles_error_image),
                    onError = {
                        Log.e("Image Loading", "Error loading an image, check network connectivity")
                    },
                    placeholder = painterResource(R.drawable.coles_loading_image),
                ),
                /* Content Description to null due to the above semantics change to the parent Column */
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = "RECIPE",
                color = MaterialTheme.colorScheme.colesRed,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                textAlign = MaterialTheme.typography.titleMedium.textAlign,
                /* Invisible to User due to the above semantics change to the parent Column */
                modifier = Modifier.semantics { invisibleToUser() }
            )
            Text(
                text = title,
                fontSize = MaterialTheme.typography.titleSmall.fontSize,
                fontWeight = MaterialTheme.typography.titleSmall.fontWeight,
                textAlign = MaterialTheme.typography.titleSmall.textAlign,
                /* Invisible to User due to the above semantics change to the parent Column */
                modifier = Modifier.semantics { invisibleToUser() }
            )
        }

    }
}