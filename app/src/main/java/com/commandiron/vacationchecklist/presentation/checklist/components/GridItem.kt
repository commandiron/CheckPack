package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.commandiron.vacationchecklist.domain.model.CheckItem
import com.commandiron.vacationchecklist.presentation.components.ImportanceLevelDot
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun GridItem(
    modifier: Modifier = Modifier,
    columnCount: Int,
    checkItem: CheckItem,
    onItemClick: (CheckItem) -> Unit
) {
    val spacing = LocalSpacing.current
    Card(
        modifier = modifier
            .clickable {
                onItemClick(checkItem)
            },
        colors = CardDefaults.cardColors(
            containerColor = getContainerColor(checkItem.isChecked),
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
                        painter = painterResource(checkItem.iconDrawable),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.padding(spacing.spaceSmall),
                        text = checkItem.name,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        style = when(columnCount){
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
                if(!checkItem.isChecked){
                    ImportanceLevelDot(
                        modifier = Modifier.size(spacing.spaceExtraSmall),
                        importanceLevel = checkItem.importanceLevel
                    )
                }
            }
        }
    }
}

@Composable
fun getContainerColor(isChecked: Boolean): Color{
    return if(isChecked){
        MaterialTheme.colorScheme.tertiaryContainer
    }else MaterialTheme.colorScheme.secondaryContainer
}