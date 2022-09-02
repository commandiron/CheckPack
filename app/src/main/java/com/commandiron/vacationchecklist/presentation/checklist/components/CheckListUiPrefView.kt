package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.GridView
import androidx.compose.material.icons.rounded.ViewList
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.presentation.checklist.ChecklistUserEvent
import com.commandiron.vacationchecklist.presentation.checklist.ChecklistViewModel
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun CheckListUiPrefView(
    modifier: Modifier = Modifier,
    gridViewEnabled: Boolean,
    sliderValue: Float,
    onListViewClick: () -> Unit,
    onGridViewClick: () -> Unit,
    onSliderValueChange: (Float) -> Unit,
    onSliderValueChangeFinished: () -> Unit,
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier.border(1.dp, if(!gridViewEnabled) Color.Gray else Color.LightGray),
            onClick = onListViewClick
        ) {
            Icon(
                imageVector = Icons.Rounded.ViewList,
                contentDescription = null,
                tint = if(!gridViewEnabled){
                    MaterialTheme.colorScheme.tertiaryContainer
                } else Color.Gray.copy(
                    alpha = 0.2f
                )
            )
        }
        IconButton(
            modifier = Modifier.border(1.dp, if(gridViewEnabled) Color.Gray else Color.LightGray),
            onClick = onGridViewClick
        ) {
            Icon(
                imageVector = Icons.Rounded.GridView,
                contentDescription = null,
                tint = if(gridViewEnabled){
                    MaterialTheme.colorScheme.tertiaryContainer
                } else Color.Gray.copy(
                    alpha = 0.2f
                )
            )
        }
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Slider(
            modifier = Modifier.fillMaxWidth(),
            value = sliderValue,
            onValueChange = onSliderValueChange,
            steps = 3,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.tertiaryContainer,
                activeTrackColor = MaterialTheme.colorScheme.tertiaryContainer
            ),
            onValueChangeFinished = onSliderValueChangeFinished
        )
    }
}