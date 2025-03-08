package com.brentcodes.colesrecipes.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val ColesLightColorScheme = lightColorScheme(
    background = LightModeWhite,
    onBackground = LightModeBlack,
)

private val ColesDarkColorScheme = darkColorScheme(
    background = DarkModeBlack,
    onBackground = DarkModeWhite
)

val ColorScheme.colesRed: Color
@Composable
get() = if (isSystemInDarkTheme()) DarkModeColesRed else LightModeColesRed

val ColorScheme.textGrey: Color
    @Composable
    get() = if (isSystemInDarkTheme()) DarkModeTextGrey else LightModeTextGrey

val ColorScheme.accentGrey: Color
    @Composable
    get() = if (isSystemInDarkTheme()) DarkModeAccentGrey else LightModeAccentGrey

@Composable
fun ColesRecipesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        /*dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }*/

        darkTheme -> ColesDarkColorScheme
        else -> ColesLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}