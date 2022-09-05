package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import com.commandiron.vacationchecklist.domain.model.CheckItem
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun CheckListGridView(
    modifier: Modifier = Modifier,
    columnCount: Int,
    checkItems: List<CheckItem>,
    onItemLongClick: (CheckItem) -> Unit,
    onItemClick: (CheckItem) -> Unit
) {
    val spacing = LocalSpacing.current
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(columnCount)
    ){
        itemsIndexed(checkItems) { _, item ->
            key(item.id) {
                GridItem(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(spacing.spaceExtraSmall),
                    columnCount = columnCount,
                    checkItem = item,
                    onItemLongClick = onItemLongClick,
                    onItemClick = onItemClick
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(spacing.spaceXXXLarge))
        }
    }
}