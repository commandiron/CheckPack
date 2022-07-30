package com.commandiron.vacationchecklist.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    background = Cultured,
    onBackground = OxfordBlue,
    primaryContainer = OxfordBlue,
    onPrimaryContainer = White
)

private val LightColorPalette = lightColorScheme(
    background = Cultured,
    onBackground = OxfordBlue,
    primaryContainer = OxfordBlue,
    onPrimaryContainer = White
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