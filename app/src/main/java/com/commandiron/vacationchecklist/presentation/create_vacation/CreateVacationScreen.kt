package com.commandiron.vacationchecklist.presentation.create_vacation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.vacationchecklist.R
import com.commandiron.vacationchecklist.presentation.components.CustomHeader
import com.commandiron.vacationchecklist.presentation.components.CreateVacationBody
import com.commandiron.vacationchecklist.presentation.components.LoadingBarAnimation
import com.commandiron.vacationchecklist.presentation.components.LoadingThreeDotAnimation
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.UiEvent
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun CreateVacationScreen(
    viewModel: CreateVacationViewModel = hiltViewModel(),
    navigate: (String) -> Unit
) {
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{ event ->
            when(event) {
                is UiEvent.Navigate -> {
                    navigate(event.route)
                }
                else -> {}
            }
        }
    }
    val state = viewModel.state
    val spacing = LocalSpacing.current
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.defaultScreenPadding),
    ) {
        CustomHeader(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(R.string.create_new_vacation),
            subTitle = stringResource(R.string.you_can_create_new_vacation_for_generate_checklist),
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Divider(color = LocalContentColor.current.copy(alpha = 0.2f))
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        if(!state.fakeLoading){
            state.vacations?.let { vacations ->
                CreateVacationBody(
                    pagerState = pagerState,
                    vacations = vacations,
                    onSelect = { vacation ->
                        viewModel.onEvent(CreateVacationUserEvent.OnSelect(vacation))
                    },
                    selectedVacation = state.selectedVacation,
                    onNextClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    },
                    onVacationNameChange = { vacationName ->
                        viewModel.onEvent(CreateVacationUserEvent.OnNameChange(vacationName))
                    },
                    onFinishClick = { viewModel.onEvent(CreateVacationUserEvent.OnFinish) },
                    showAlertDialog = state.showAlertDialog,
                    onAlertDismiss = { viewModel.onEvent(CreateVacationUserEvent.OnAlertDialogDismiss) },
                    onAlertConfirm = { viewModel.onEvent(CreateVacationUserEvent.OnAlertDialogConfirm(it)) }
                )
            }
        }else{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = spacing.bottomNavigationPadding.calculateBottomPadding())
                    .padding(bottom = spacing.bottomNavigationHeight),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                LoadingBarAnimation(loadingBarDurationMillis = state.fakeLoadingDelay.toInt())
                Spacer(modifier = Modifier.height(spacing.spaceSmall))
                LoadingThreeDotAnimation(stringResource(R.string.creating))
            }
        }
    }
    BackHandler(enabled = pagerState.currentPage == 1) {
        coroutineScope.launch {
            pagerState.animateScrollToPage(0)
        }
    }
}