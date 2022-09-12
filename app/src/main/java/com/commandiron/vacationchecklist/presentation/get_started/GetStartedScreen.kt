package com.commandiron.vacationchecklist.presentation.get_started

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
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
import com.commandiron.vacationchecklist.presentation.components.CustomButton
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.UiEvent
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun GetStartedScreen(
    viewModel: GetStartedViewModel = hiltViewModel(),
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
            title = stringResource(R.string.select_vacation),
            subTitle = stringResource(R.string.select_a_vacation_for_generate_checklist),
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
                        viewModel.onEvent(GetStartedUserEvent.OnSelect(vacation))
                    },
                    selectedVacation = state.selectedVacation,
                    nextButtonEnabled = false,
                    onVacationNameChange = { vacationName ->
                        viewModel.onEvent(GetStartedUserEvent.OnNameChange(vacationName))
                    },
                    onFinishClick = { viewModel.onEvent(GetStartedUserEvent.OnFinish(it)) },
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
        BackHandler(enabled = pagerState.currentPage == 1) {
            coroutineScope.launch {
                pagerState.animateScrollToPage(0)
            }
        }
    }
    state.selectedVacation?.let {
        if(pagerState.currentPage != 1){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = spacing.bottomNavigationPadding.calculateBottomPadding())
                    .padding(bottom = spacing.bottomNavigationHeight),
                contentAlignment = Alignment.BottomCenter
            ) {
                CustomButton(
                    modifier = Modifier.fillMaxWidth(0.60f),
                    text = stringResource(R.string.get_started),
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    }
                )
            }
        }
    }
}