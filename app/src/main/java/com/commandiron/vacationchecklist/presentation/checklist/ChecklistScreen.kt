package com.commandiron.vacationchecklist.presentation.checklist

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.vacationchecklist.presentation.checklist.components.*
import com.commandiron.vacationchecklist.presentation.components.CustomAlertDialog
import com.commandiron.vacationchecklist.presentation.components.LoadingThreeDotAnimation
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.Strings
import com.commandiron.vacationchecklist.util.Strings.English.LOADING
import com.commandiron.vacationchecklist.util.Strings.English.PLEASE_CREATE_VACATION
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
                text = vacation.name,
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
                        checkListItems = vacation.checklistItems,
                        onItemClick = {
                            viewModel.onEvent(
                                ChecklistUserEvent.OnCheck(vacation.checklistItems[it])
                            )
                        }
                    )
                }else{
                    CheckListListView(
                        modifier = Modifier.padding(horizontal = spacing.spaceMedium),
                        viewModel = viewModel,
                        vacation = vacation
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
    if(state.showAlertDialog){
        CustomAlertDialog(
            title = Strings.English.IN_YOUR_BAG,
            onDismiss = { viewModel.onEvent(ChecklistUserEvent.OnAlertDialogDismiss) },
            onConfirm = { viewModel.onEvent(ChecklistUserEvent.OnAlertDialogConfirm) }
        )
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

















