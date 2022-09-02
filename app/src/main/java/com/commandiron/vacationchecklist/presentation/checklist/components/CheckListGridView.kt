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
import com.commandiron.vacationchecklist.domain.model.Vacation
import com.commandiron.vacationchecklist.presentation.checklist.ChecklistUserEvent
import com.commandiron.vacationchecklist.presentation.checklist.ChecklistViewModel
import com.commandiron.vacationchecklist.presentation.components.CustomAlertDialog
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.Strings

@Composable
fun CheckListGridView(
    modifier: Modifier = Modifier,
    viewModel: ChecklistViewModel,
    vacation: Vacation
) {
    val state = viewModel.state
    val spacing = LocalSpacing.current
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(state.gridCellsCount)
    ){
        items(
            count = vacation.checklistItems.size,
            key = {
                vacation.checklistItems[it].id
            }
        ){ index ->
            GridItem(
                modifier = Modifier
                    .aspectRatio(1f)
                    .clickable {
                        viewModel.onEvent(
                            ChecklistUserEvent.OnCheck(index, vacation.checklistItems[index])
                        )
                    }
                    .padding(spacing.spaceExtraSmall),
                gridCellsCount = state.gridCellsCount,
                checklistItem = vacation.checklistItems[index]
            )
        }
        item {
            Spacer(modifier = Modifier.height(spacing.spaceXXXLarge))
        }
    }
}