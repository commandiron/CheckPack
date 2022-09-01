package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.presentation.components.ImportanceLevelDot
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun GridItem(
    modifier: Modifier = Modifier,
    gridCellsCount: Int,
    checklistItem: ChecklistItem,
    isChecked: Boolean
) {
    val spacing = LocalSpacing.current
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = if(isChecked) {
                MaterialTheme.colorScheme.tertiaryContainer
            } else MaterialTheme.colorScheme.secondaryContainer,
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.padding(spacing.spaceSmall),
                        painter = painterResource(checklistItem.iconDrawable),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1.5f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.padding(spacing.spaceSmall),
                        text = checklistItem.name,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        style = when(gridCellsCount){
                            1 -> MaterialTheme.typography.headlineSmall
                            2 -> MaterialTheme.typography.bodyMedium
                            3 -> MaterialTheme.typography.bodySmall
                            4 -> MaterialTheme.typography.labelLarge
                            5 -> MaterialTheme.typography.labelLarge
                            else -> MaterialTheme.typography.bodySmall
                        }
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing.spaceSmall),
                contentAlignment = Alignment.TopStart
            ) {
                if(!isChecked){
                    ImportanceLevelDot(
                        modifier = Modifier.size(spacing.spaceExtraSmall),
                        importanceLevel = checklistItem.importanceLevel
                    )
                }
            }
        }
    }
}