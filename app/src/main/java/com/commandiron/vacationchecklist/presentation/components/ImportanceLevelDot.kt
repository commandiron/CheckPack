package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ImportanceLevelDot(
    modifier: Modifier = Modifier,
    importanceLevel: Int
) {
    Surface(
        modifier = modifier,
        color = when(importanceLevel){
            1 -> Color.Red
            2 -> Color.Blue
            3 -> Color.Green
            else -> Color.Red
        },
        shape = CircleShape
    ) {
    }
}