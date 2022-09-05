package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.commandiron.vacationchecklist.domain.model.CheckItem

@Composable
fun ImportanceLevelDot(
    modifier: Modifier = Modifier,
    importanceLevel: CheckItem.ImportanceLevel
) {
    Surface(
        modifier = modifier,
        color = when(importanceLevel){
            CheckItem.ImportanceLevel.MUST -> Color.Red
            CheckItem.ImportanceLevel.OPTIONAL -> Color.Blue
        },
        shape = CircleShape
    ) {
    }
}