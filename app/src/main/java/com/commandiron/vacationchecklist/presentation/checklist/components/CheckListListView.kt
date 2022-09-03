package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.domain.model.Vacation
import com.commandiron.vacationchecklist.presentation.checklist.ChecklistUserEvent
import com.commandiron.vacationchecklist.presentation.checklist.ChecklistViewModel
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun CheckListListView(
    modifier: Modifier = Modifier,
    listItemHeightValue: Float,
    gridColumnCount: Int,
    checklistItems: List<ChecklistItem>,
    onCheckedChange: (Int) -> Unit
) {
    val spacing = LocalSpacing.current
    LazyColumn(
        modifier = modifier
    ) {
        items(
            count = checklistItems.size,
        ){ index ->
            ColumnItem(
                modifier = Modifier
                    .height(Dp(listItemHeightValue))
                    .fillMaxWidth(),
                gridCellsCount = gridColumnCount,
                checklistItem = checklistItems[index],
                onCheckedChange = { onCheckedChange(index) }
            )
        }
        item {
            Spacer(modifier = Modifier.height(spacing.spaceXXLarge))
        }
    }
}