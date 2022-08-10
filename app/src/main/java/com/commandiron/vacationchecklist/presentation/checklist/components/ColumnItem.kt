package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.presentation.components.CustomCircularIcon
import com.commandiron.vacationchecklist.presentation.components.ImportanceLevelDot
import com.commandiron.vacationchecklist.ui.theme.iconBackgroundColor
import com.commandiron.vacationchecklist.util.LocalSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnItem(
    checklistItem: ChecklistItem,
    listScale: Int,
    onCheckedChange:(Boolean) -> Unit
) {
    val spacing = LocalSpacing.current
    Surface(
        modifier = Modifier
            .height(
                when(listScale){
                    1 -> spacing.bottomNavigationHeight / 2
                    2 -> spacing.bottomNavigationHeight
                    3 -> spacing.bottomNavigationHeight * 2
                    else -> spacing.bottomNavigationHeight
                }

            )
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = RoundedCornerShape(spacing.spaceMedium)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.spaceSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment =
                    when(listScale){
                        1 -> Alignment.Center
                        2 -> Alignment.CenterStart
                        3 -> Alignment.CenterStart
                        else -> Alignment.CenterStart
                    }
            ) {
                CustomCircularIcon(
                    surfaceShape = RoundedCornerShape(spacing.spaceSmall),
                    surfaceColor = iconBackgroundColor,
                    iconDrawable = checklistItem.iconDrawable,
                    iconPadding = when(listScale){
                        1 -> 0.dp
                        2 -> spacing.spaceExtraSmall
                        3 -> spacing.spaceExtraSmall
                        else -> spacing.spaceExtraSmall
                    }
                )
            }
            Spacer(
                modifier = Modifier.width(
                    when(listScale){
                        1 -> 0.dp
                        2 -> spacing.spaceSmall
                        3 -> spacing.spaceLarge
                        else -> spacing.spaceSmall
                    }
                )
            )
            Row(
                modifier = Modifier.weight(3f),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImportanceLevelDot(
                    modifier = Modifier.size(spacing.spaceExtraSmall),
                    importanceLevel = checklistItem.importanceLevel
                )
                Spacer(modifier = Modifier.width(spacing.spaceSmall))
                Text(
                    text = checklistItem.name,
                    style =  when(listScale){
                        1 -> MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
                        2 -> MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                        3 -> MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium)
                        else -> MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                    }
                )
            }
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.CenterEnd
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
    }
}