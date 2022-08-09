package com.commandiron.vacationchecklist.presentation.get_started

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.vacationchecklist.presentation.components.*
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.Strings.English.CREATING
import com.commandiron.vacationchecklist.util.Strings.English.GET_STARTED
import com.commandiron.vacationchecklist.util.Strings.English.SELECT_A_VACATION_FOR_GENERATE_CHECKLIST
import com.commandiron.vacationchecklist.util.Strings.English.SELECT_VACATION
import com.commandiron.vacationchecklist.util.UiEvent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
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
            title = SELECT_VACATION,
            subTitle = SELECT_A_VACATION_FOR_GENERATE_CHECKLIST,
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
                LoadingThreeDotAnimation(text = CREATING)
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
                    text = GET_STARTED,
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