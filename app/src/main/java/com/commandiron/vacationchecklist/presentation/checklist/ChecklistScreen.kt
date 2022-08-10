package com.commandiron.vacationchecklist.presentation.checklist

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.GridView
import androidx.compose.material.icons.rounded.ViewList
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.vacationchecklist.presentation.checklist.components.ChecklistHeader
import com.commandiron.vacationchecklist.presentation.checklist.components.ColumnItem
import com.commandiron.vacationchecklist.presentation.checklist.components.GridItem
import com.commandiron.vacationchecklist.presentation.checklist.components.ReadyToGoView
import com.commandiron.vacationchecklist.presentation.components.CustomAlertDialog
import com.commandiron.vacationchecklist.presentation.components.LoadingThreeDotAnimation
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.Strings
import com.commandiron.vacationchecklist.util.Strings.English.IN_YOUR_BAG
import com.commandiron.vacationchecklist.util.Strings.English.LOADING
import com.commandiron.vacationchecklist.util.Strings.English.NO
import com.commandiron.vacationchecklist.util.Strings.English.PLEASE_CREATE_VACATION
import com.commandiron.vacationchecklist.util.Strings.English.YES
import com.commandiron.vacationchecklist.util.UiEvent

@Composable
fun ChecklistScreen(
    viewModel: ChecklistViewModel = hiltViewModel(),
    navigate: (String) -> Unit
) {
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{ event ->
            when(event) {
                is UiEvent.Navigate -> {
                    navigate(event.route)
                }
            }
        }
    }
    val state = viewModel.state
    val spacing = LocalSpacing.current
    state.activeVacation?.let { vacation ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = spacing.defaultScreenPadding.calculateTopPadding())
        ) {
            ChecklistHeader(
                vacation = vacation,
                checkCount = state.checkCount,
                totalCount = state.totalCheckCount,
                isChecklistCompeted = state.isChecklistCompeted
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceLarge),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    modifier = Modifier.border(1.dp, if(!state.gridViewEnabled) Color.Gray else Color.LightGray),
                    onClick = { viewModel.onEvent(ChecklistUserEvent.OnListViewClick) }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ViewList,
                        contentDescription = null,
                        tint = if(!state.gridViewEnabled){
                            MaterialTheme.colorScheme.tertiaryContainer
                        } else Color.Gray.copy(
                            alpha = 0.2f
                        )
                    )
                }
                IconButton(
                    modifier = Modifier.border(1.dp, if(state.gridViewEnabled) Color.Gray else Color.LightGray),
                    onClick = { viewModel.onEvent(ChecklistUserEvent.OnGridViewClick) }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.GridView,
                        contentDescription = null,
                        tint = if(state.gridViewEnabled){
                            MaterialTheme.colorScheme.tertiaryContainer
                        } else Color.Gray.copy(
                            alpha = 0.2f
                        )
                    )
                }
                Spacer(modifier = Modifier.width(spacing.spaceSmall))
                Slider(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.sliderValue,
                    onValueChange = { viewModel.onEvent(ChecklistUserEvent.OnSliderChange(it)) },
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.tertiaryContainer,
                        activeTrackColor = MaterialTheme.colorScheme.tertiaryContainer
                    ),
                    onValueChangeFinished = { viewModel.onEvent(ChecklistUserEvent.OnSliderValueChangeFinished) }
                )
            }
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            if(state.isChecklistCompeted){
                ReadyToGoView(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = spacing.bottomNavigationPadding.calculateBottomPadding())
                        .padding(bottom = spacing.bottomNavigationHeight)
                        .padding(bottom = spacing.spaceExtraLarge),
                    onClick = {viewModel.onEvent(ChecklistUserEvent.OnChecklistCompleteBack)}
                )
            }else{
                if(state.gridViewEnabled){
                    LazyVerticalGrid(
                        modifier = Modifier
                            .padding(horizontal = spacing.spaceMedium),
                        columns = GridCells.Fixed(
                            when(state.listScale){
                                1 -> 4
                                2 -> 3
                                3 -> 2
                                else -> 3
                            }
                        )
                    ){
                        itemsIndexed(vacation.checklistItems){ index, checklistItem ->
                            GridItem(
                                checklistItem = checklistItem,
                                isChecked = checklistItem.isChecked,
                                listScale = state.listScale,
                                onClick = {
                                    viewModel.onEvent(ChecklistUserEvent.OnCheck(index, checklistItem))
                                }
                            )
                            if(state.showAlertDialog){
                                CustomAlertDialog(
                                    title = IN_YOUR_BAG,
                                    onDismiss = { viewModel.onEvent(ChecklistUserEvent.OnAlertDialogDismiss) },
                                    onConfirm = { viewModel.onEvent(ChecklistUserEvent.OnAlertDialogConfirm) }
                                )
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.height(spacing.spaceXXXLarge))
                        }
                    }
                }else{
                    LazyColumn(
                        modifier = Modifier
                            .padding(horizontal = spacing.spaceMedium)
                    ) {
                        itemsIndexed(vacation.checklistItems){ index, checklistItem ->
                            ColumnItem(
                                checklistItem = checklistItem,
                                listScale = state.listScale,
                                onCheckedChange = {
                                    viewModel.onEvent(ChecklistUserEvent.OnCheck(index, checklistItem))
                                }
                            )
                            Spacer(modifier = Modifier.height(spacing.spaceSmall))
                            if(state.showAlertDialog){
                                CustomAlertDialog(
                                    title = IN_YOUR_BAG,
                                    onDismiss = { viewModel.onEvent(ChecklistUserEvent.OnAlertDialogDismiss) },
                                    onConfirm = { viewModel.onEvent(ChecklistUserEvent.OnAlertDialogConfirm) }
                                )
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.height(spacing.spaceXXLarge))
                        }
                    }
                }
            }
        }
    }
    if(state.isLoading){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = spacing.defaultScreenPadding.calculateTopPadding()),
            contentAlignment = Alignment.Center
        ) {
            LoadingThreeDotAnimation(text = LOADING)
        }
    }else{
        if(state.activeVacation == null){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = spacing.defaultScreenPadding.calculateTopPadding()),
                contentAlignment = Alignment.Center
            ) {
                Text(text = PLEASE_CREATE_VACATION)
            }
        }
    }
}

















