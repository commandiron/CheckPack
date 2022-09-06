package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.commandiron.vacationchecklist.domain.model.CheckItem
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun CheckListListView(
    modifier: Modifier = Modifier,
    listItemHeightValue: Float,
    gridColumnCount: Int,
    checkItems: List<CheckItem>,
    onFlagClick: (CheckItem) -> Unit,
    onCheckedChange: (CheckItem) -> Unit
) {
    val spacing = LocalSpacing.current
    LazyColumn(
        modifier = modifier
    ) {
        itemsIndexed(checkItems) { _, item ->
            key(item.id) {
                ColumnItem(
                    modifier = Modifier
                        .height(Dp(listItemHeightValue))
                        .fillMaxWidth()
                        .padding(spacing.spaceXXSmall),
                    gridCellsCount = gridColumnCount,
                    checkItem = item,
                    onFlagClick = onFlagClick,
                    onCheckedChange = onCheckedChange
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(spacing.spaceXXLarge))
        }
    }
}