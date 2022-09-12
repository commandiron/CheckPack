package com.commandiron.vacationchecklist.util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalSpacing = compositionLocalOf { Dimensions() }

data class Dimensions(
    val default: Dp = 0.dp,
    val spaceXXSmall: Dp = 2.dp,
    val spaceExtraSmall: Dp = 4.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceLarge: Dp = 32.dp,
    val spaceExtraLarge: Dp = 64.dp,
    val spaceXXLarge: Dp = 128.dp,
    val spaceXXXLarge: Dp = 256.dp,

    val bottomNavigationHeight: Dp = 64.dp,
    val defaultButtonHeight: Dp = 52.dp,
    val bottomNavigationPadding: PaddingValues = PaddingValues(
        bottom = 24.dp,
        start = 24.dp,
        end = 24.dp
    ),
    val defaultScreenPadding: PaddingValues = PaddingValues(
        top = spaceLarge,
        start = spaceLarge,
        end = spaceLarge
    ),
)
val LocalSnackbarHostState = compositionLocalOf<SnackbarHostState> {
    error("No Permission State")
}

fun getProvidedValues(
    snackbarHostState: SnackbarHostState
): Array<ProvidedValue<*>> {
    return arrayOf(
        LocalSnackbarHostState provides snackbarHostState
    )
}

object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor(): Color = Color.Transparent

    @Composable
    override fun rippleAlpha() = RippleAlpha(
        draggedAlpha = 0.0f,
        focusedAlpha = 0.0f,
        hoveredAlpha = 0.0f,
        pressedAlpha = 0.0f,
    )
}
