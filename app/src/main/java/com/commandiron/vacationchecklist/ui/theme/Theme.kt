package com.commandiron.vacationchecklist.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    background = Cultured,
    onBackground = OxfordBlue,
    primary = OxfordBlue,
    onPrimary = Color.White,
    primaryContainer = Bluetiful,
    onPrimaryContainer = Color.White,
    secondaryContainer = Color.White,
    onSecondaryContainer = Color.Black,
    tertiaryContainer = MaximumYellowRed,
    onTertiaryContainer = OxfordBlue
)

private val LightColorPalette = lightColorScheme(
    background = Cultured,
    onBackground = OxfordBlue,
    primary = OxfordBlue,
    onPrimary = Color.White,
    primaryContainer = Bluetiful,
    onPrimaryContainer = Color.White,
    secondaryContainer = Color.White,
    onSecondaryContainer = Color.Black,
    tertiaryContainer = MaximumYellowRed,
    onTertiaryContainer = OxfordBlue
)

@Composable
fun VacationCheckListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}