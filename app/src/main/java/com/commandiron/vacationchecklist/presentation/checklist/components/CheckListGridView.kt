package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun CheckListGridView(
    modifier: Modifier = Modifier,
    columnCount: Int,
    checkListItems: List<ChecklistItem>,
    onItemClick: (Int) -> Unit
) {
    val spacing = LocalSpacing.current
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(columnCount)
    ){
        items(
            count = checkListItems.size,
            key = {
                checkListItems[it].id
            }
        ){ index ->
            GridItem(
                modifier = Modifier
                    .aspectRatio(1f)
                    .clickable {
                        println(index)
                        onItemClick(index)
                    }
                    .padding(spacing.spaceExtraSmall),
                columnCount = columnCount,
                checklistItem = checkListItems[index]
            )
        }
        item {
            Spacer(modifier = Modifier.height(spacing.spaceXXXLarge))
        }
    }
}