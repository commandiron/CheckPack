package com.commandiron.vacationchecklist.presentation.checklist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.vacationchecklist.R
import com.commandiron.vacationchecklist.presentation.checklist.components.*
import com.commandiron.vacationchecklist.presentation.components.CustomAlertDialog
import com.commandiron.vacationchecklist.presentation.components.LoadingThreeDotAnimation
import com.commandiron.vacationchecklist.util.LocalSpacing
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
        state.checkItems?.let { checkItems ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = spacing.defaultScreenPadding.calculateTopPadding())
            ) {
                ChecklistHeader(
                    title = stringResource(R.string.checklist),
                    vacationName = vacation.name,
                    drawableId = vacation.iconDrawable,
                    checkCount = state.checkCount,
                    totalCount = state.totalCheckCount,
                    isChecklistCompeted = state.isChecklistCompeted
                )
                CheckListUiPrefView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = spacing.spaceLarge),
                    gridViewEnabled = state.gridViewEnabled,
                    sliderValue = state.sliderValue,
                    onListViewClick = { viewModel.onEvent(ChecklistUserEvent.OnListViewClick) },
                    onGridViewClick = { viewModel.onEvent(ChecklistUserEvent.OnGridViewClick) },
                    onSliderValueChange = { viewModel.onEvent(ChecklistUserEvent.OnSliderChange(it)) },
                    onSliderValueChangeFinished = {
                        viewModel.onEvent(ChecklistUserEvent.OnSliderValueChangeFinished)
                    }
                )
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                if(!state.isChecklistCompeted){
                    if(state.gridViewEnabled){
                        CheckListGridView(
                            modifier = Modifier.padding(horizontal = spacing.spaceMedium),
                            columnCount = state.gridColumnCount,
                            checkItems = checkItems,
                            onItemLongClick = {
                                viewModel.onEvent(ChecklistUserEvent.OnMark(it))
                            },
                            onItemClick = {
                                viewModel.onEvent(ChecklistUserEvent.OnCheck(it))
                            }
                        )
                    }else{
                        CheckListListView(
                            modifier = Modifier.padding(horizontal = spacing.spaceMedium),
                            listItemHeightValue = state.listItemHeightValue,
                            gridColumnCount = state.gridColumnCount,
                            checkItems = checkItems,
                            onFlagClick = {
                                viewModel.onEvent(ChecklistUserEvent.OnMark(it))
                            },
                            onCheckedChange = {
                                viewModel.onEvent(ChecklistUserEvent.OnCheck(it))
                            }
                        )
                    }
                }else{
                    ReadyToGoView(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = spacing.bottomNavigationPadding.calculateBottomPadding())
                            .padding(bottom = spacing.bottomNavigationHeight)
                            .padding(bottom = spacing.spaceExtraLarge),
                        onClick = {viewModel.onEvent(ChecklistUserEvent.OnChecklistCompleteBack)}
                    )
                }
            }
        }
    }
    if(state.showCheckAlertDialog){
        CustomAlertDialog(
            title = stringResource(R.string.in_your_bag),
            firstButtonText = stringResource(R.string.yes),
            secondButtonText = stringResource(R.string.no),
            onDismiss = { viewModel.onEvent(ChecklistUserEvent.OnCheckAlertDialogDismiss) },
            onConfirm = { viewModel.onEvent(ChecklistUserEvent.OnCheckAlertDialogConfirm) }
        )
    }
    if(state.showMarkAlertDialog){
        state.markedItem?.isMarked?.let { isMarked ->
            MarkAlertDialog(
                title = if(isMarked) {
                    stringResource(R.string.remove_mark)
                } else stringResource(R.string.mark_as_important),
                firstButtonText = stringResource(R.string.yes),
                secondButtonText = stringResource(R.string.no),
                setAlarmButtonEnabled = !isMarked,
                onSetAlarm = { viewModel.onEvent(ChecklistUserEvent.OnSetAlarm) },
                onDismiss = { viewModel.onEvent(ChecklistUserEvent.OnMarkAlertDialogDismiss) },
                onConfirm = { viewModel.onEvent(ChecklistUserEvent.OnMarkAlertDialogConfirm) }
            )
        }
    }
    if(state.showSetAlarmAlertDialog){
        SetAlarmAlertDialog(
            title = "Set Alarm",
            onDismiss = { viewModel.onEvent(ChecklistUserEvent.OnSetAlarmAlertDialogDismiss) },
            onConfirm = { viewModel.onEvent(ChecklistUserEvent.OnSetAlarmAlertDialogConfirm) }
        )
    }
    if(state.isLoading){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = spacing.defaultScreenPadding.calculateTopPadding()),
            contentAlignment = Alignment.Center
        ) {
            LoadingThreeDotAnimation(stringResource(R.string.loading))
        }
    }else{
        if(state.activeVacation == null){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = spacing.defaultScreenPadding.calculateTopPadding()),
                contentAlignment = Alignment.Center
            ) {
                Text(stringResource(R.string.please_create_vacation))
            }
        }
    }
}

















