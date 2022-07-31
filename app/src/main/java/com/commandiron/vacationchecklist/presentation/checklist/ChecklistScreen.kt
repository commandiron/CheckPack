package com.commandiron.vacationchecklist.presentation.checklist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.presentation.components.VacationIcon
import com.commandiron.vacationchecklist.presentation.model.checklistItems
import com.commandiron.vacationchecklist.presentation.model.vacations
import com.commandiron.vacationchecklist.util.LocalSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChecklistScreen() {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = spacing.defaultScreenPadding.calculateTopPadding())
    ) {
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(spacing.bottomNavigationHeight)
                    .padding(horizontal = spacing.spaceMedium),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Checklist",
                    style = MaterialTheme.typography.displayMedium
                )
                Divider(color = LocalContentColor.current.copy(alpha = 0.2f))
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(spacing.bottomNavigationHeight),
                shape = RoundedCornerShape(
                    topStart = spacing.spaceLarge,
                    bottomStart = spacing.spaceLarge
                ),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(spacing.spaceSmall),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    VacationIcon(
                        iconDrawable = vacations[0].iconDrawable
                    )
                    Spacer(modifier = Modifier.width(spacing.spaceMedium))
                    Text(
                        text = vacations[0].name,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(spacing.spaceLarge))
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = spacing.spaceMedium)
        ) {
            items(checklistItems){ checklistItem ->
                Surface(
                    modifier = Modifier
                        .height(spacing.bottomNavigationHeight)
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
                            contentAlignment = Alignment.CenterStart
                        ) {
                            VacationIcon(
                                surfaceShape = RoundedCornerShape(spacing.spaceSmall),
                                surfaceColor = Color(0xFFECEFF3),
                                iconDrawable = checklistItem.iconDrawable,
                                iconPadding = spacing.spaceExtraSmall
                            )
                        }
                        Row(
                            modifier = Modifier.weight(3f),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                modifier = Modifier.size(spacing.spaceExtraSmall),
                                color = checklistItem.importanceLevel.color,
                                shape = CircleShape
                            ) {
                            }
                            Spacer(modifier = Modifier.width(spacing.spaceSmall))
                            Text(
                                text = checklistItem.name,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.SemiBold
                                )
                            )
                        }
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Checkbox(
                                checked = checklistItem.isChecked,
                                onCheckedChange = {},
                                colors = CheckboxDefaults.colors(
                                    checkedColor = MaterialTheme.colorScheme.tertiaryContainer,
                                    uncheckedColor = MaterialTheme.colorScheme.tertiaryContainer,
                                    checkmarkColor = MaterialTheme.colorScheme.onTertiaryContainer
                                )
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
            }
            item {
                Spacer(modifier = Modifier.height(spacing.spaceXXLarge))
            }
        }
    }
}

















