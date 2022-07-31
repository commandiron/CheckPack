package com.commandiron.vacationchecklist.presentation.checklist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.sp
import com.commandiron.vacationchecklist.presentation.checklist.components.CheckListHeader
import com.commandiron.vacationchecklist.presentation.components.CircularVacationIcon
import com.commandiron.vacationchecklist.presentation.components.VacationItem
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
                    CircularVacationIcon(
                        iconDrawable = vacations[1].iconDrawable
                    )
                    Spacer(modifier = Modifier.width(spacing.spaceMedium))
                    Text(
                        text = vacations[1].name,
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
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(spacing.spaceLarge)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = checklistItem.iconDrawable),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = checklistItem.name)
                        }
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            Checkbox(
                                checked = checklistItem.isChecked,
                                onCheckedChange = {}
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

















