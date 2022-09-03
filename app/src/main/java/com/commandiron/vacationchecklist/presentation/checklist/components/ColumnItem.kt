package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.compiler.plugins.kotlin.ComposeFqNames.remember
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.domain.model.CheckItem
import com.commandiron.vacationchecklist.presentation.components.ImportanceLevelDot
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun ColumnItem(
    modifier: Modifier = Modifier,
    gridCellsCount: Int,
    checkItem: CheckItem,
    onCheckedChange: (Boolean) -> Unit
) {
    val spacing = LocalSpacing.current
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    when(gridCellsCount){
                        1 -> spacing.spaceSmall
                        2 -> spacing.spaceSmall
                        3 -> spacing.spaceSmall
                        else -> 0.dp
                    }
                )
        ){
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(
                        when(gridCellsCount){
                            1 -> 1.5f
                            else -> 1f
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(checkItem.iconDrawable),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(3f),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(spacing.spaceMedium))
                    ImportanceLevelDot(
                        modifier = Modifier.size(spacing.spaceExtraSmall),
                        importanceLevel = checkItem.importanceLevel
                    )
                    Spacer(modifier = Modifier.width(spacing.spaceSmall))
                    Text(
                        text = checkItem.name,
                        style = MaterialTheme.typography.bodyLarge,
                        overflow = when(gridCellsCount){
                            5 -> TextOverflow.Ellipsis
                            4 -> TextOverflow.Ellipsis
                            else -> TextOverflow.Clip
                        }
                    )
                }

            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Checkbox(
                    checked = checkItem.isChecked,
                    onCheckedChange = onCheckedChange,
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colorScheme.tertiaryContainer,
                        uncheckedColor = MaterialTheme.colorScheme.tertiaryContainer,
                        checkmarkColor = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                )
            }
        }
    }
}