package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.domain.model.CheckItem
import com.commandiron.vacationchecklist.presentation.components.ImportanceLevelDot
import com.commandiron.vacationchecklist.ui.theme.importantBorderColor
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun ColumnItem(
    modifier: Modifier = Modifier,
    gridCellsCount: Int,
    checkItem: CheckItem,
    onFlagClick: (CheckItem) -> Unit,
    onCheckedChange: (CheckItem) -> Unit
) {
    val spacing = LocalSpacing.current
    Card(
        modifier = modifier
            .border(
                width = 2.dp,
                color = if (checkItem.isMarked) importantBorderColor else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    when (gridCellsCount) {
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
                        when (gridCellsCount) {
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
                Icon(
                    modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource()},
                            indication = null
                        ) {
                            onFlagClick(checkItem)
                        },
                    imageVector = Icons.Default.Flag,
                    contentDescription = null,
                    tint = getFlagTintColor(checkItem.isMarked)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Checkbox(
                    checked = checkItem.isChecked,
                    onCheckedChange = { onCheckedChange(checkItem) },
                    enabled = !checkItem.isMarked,
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colorScheme.primaryContainer,
                        uncheckedColor = MaterialTheme.colorScheme.primaryContainer,
                        checkmarkColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        }
    }
}

@Composable
private fun getFlagTintColor(isMarked: Boolean): Color{
    return if(isMarked){
        MaterialTheme.colorScheme.tertiaryContainer
    }else{
        MaterialTheme.colorScheme.onSurface.copy(0.38f)
    }
}