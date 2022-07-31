package com.commandiron.vacationchecklist.presentation.model

import androidx.compose.ui.graphics.Color

sealed class ImportanceLevel(val color: Color) {
    object MUST : ImportanceLevel(color = Color.Red)
    object NECESSARY: ImportanceLevel(color = Color.Blue)
    object OPTIONAL: ImportanceLevel(color = Color.Green)
}