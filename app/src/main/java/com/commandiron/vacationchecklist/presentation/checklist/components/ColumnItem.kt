package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.commandiron.handy_compose.core.HandyCard
import com.commandiron.handy_compose.core.HandyRowCard
import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.presentation.components.CustomCircularIcon
import com.commandiron.vacationchecklist.presentation.components.ImportanceLevelDot
import com.commandiron.vacationchecklist.ui.theme.iconBackgroundColor
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun ColumnItem(
    modifier: Modifier = Modifier,
    checklistItem: ChecklistItem,
    onCheckedChange: (Boolean) -> Unit
) {
    val spacing = LocalSpacing.current
    HandyRowCard(
        modifier = modifier,
        color = MaterialTheme.colorScheme.secondaryContainer,
        shadowElevation = 4.dp,
        startContentWeight = 1f,
        startContent = {
            HandyCard(
                modifier = Modifier.fillMaxSize(),
                shapeSizeFraction = 0f,
                color = LocalContentColor.current.copy(0f)
            ) {
                Icon(
                    painter = painterResource(checklistItem.iconDrawable),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        },
        centerContentWeight = 3f,
        centerContent = {
            Text(
                text = checklistItem.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall,
                overflow = TextOverflow.Ellipsis
            )
        },
        endContentWeight = 1f,
        endContent = {
            HandyCard(
                modifier = Modifier.fillMaxSize(),
                shapeSizeFraction = 0f,
                paddingFraction = 0.1f,
                color = LocalContentColor.current.copy(0f)
            ) {
                Checkbox(
                    checked = checklistItem.isChecked,
                    onCheckedChange = onCheckedChange,
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colorScheme.tertiaryContainer,
                        uncheckedColor = MaterialTheme.colorScheme.tertiaryContainer,
                        checkmarkColor = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                )
            }
        }
    )
}