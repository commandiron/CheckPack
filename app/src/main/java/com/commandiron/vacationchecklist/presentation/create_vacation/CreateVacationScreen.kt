package com.commandiron.vacationchecklist.presentation.create_vacation

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
import com.commandiron.vacationchecklist.presentation.create_vacation.components.CreateVacationHeader
import com.commandiron.vacationchecklist.presentation.components.VacationItem
import com.commandiron.vacationchecklist.presentation.components.VacationsVerticalList
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.UiEvent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
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
        CreateVacationHeader(
            modifier = Modifier.fillMaxWidth(),
            title = "Create New Vacation",
            subTitle = "You can create new vacation for generate checklist",
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Divider(color = LocalContentColor.current.copy(alpha = 0.2f))
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        if(!state.fakeLoading){
            state.vacations?.let {
                HorizontalPager(
                    count = 2,
                    state = pagerState,
                    userScrollEnabled = false,
                    verticalAlignment = Alignment.Top
                ) { page ->
                    when(page){
                        0 -> {
                            Column {
                                VacationsVerticalList(
                                    vacations = it, //Bu kısım domainden gelecek.
                                    onSelect = { viewModel.onEvent(CreateVacationUserEvent.OnSelect(it)) }
                                )
                                state.selectedVacation?.let {
                                    Button(
                                        modifier = Modifier.align(Alignment.CenterHorizontally),
                                        onClick = {
                                            coroutineScope.launch {
                                                pagerState.animateScrollToPage(1)
                                            }
                                        },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = MaterialTheme.colorScheme.primaryContainer
                                        )
                                    ) {
                                        Text(
                                            text = "NEXT",
                                            style = MaterialTheme.typography.titleMedium,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                        }
                        1 -> {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                state.selectedVacation?.let {
                                    Text(
                                        text = "Enter vacation name",
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                    Spacer(modifier = Modifier.height(spacing.spaceLarge))
                                    Column(modifier = Modifier.weight(1f)) {
                                        VacationItem(
                                            showTitle = false,
                                            vacation = it,
                                            iconPadding = spacing.spaceSmall
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(spacing.spaceLarge))
                                    Column(modifier = Modifier.weight(2f)) {
                                        TextField(
                                            value = it.name,
                                            onValueChange = { viewModel.onEvent(CreateVacationUserEvent.OnNameChange(it)) },
                                            singleLine = true
                                        )
                                        Spacer(modifier = Modifier.height(spacing.spaceLarge))
                                        Button(
                                            modifier = Modifier.align(Alignment.CenterHorizontally),
                                            onClick = { viewModel.onEvent(CreateVacationUserEvent.OnFinish) },
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = MaterialTheme.colorScheme.primaryContainer
                                            )
                                        ) {
                                            Text(
                                                text = "FINISH",
                                                style = MaterialTheme.typography.titleMedium,
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    }
                                    if(state.showAlertDialog){
                                        AlertDialog(
                                            onDismissRequest = { viewModel.onEvent(CreateVacationUserEvent.OnAlertDialogDismiss) },
                                            confirmButton = {
                                                Button(
                                                    onClick = { viewModel.onEvent(CreateVacationUserEvent.OnAlertDialogConfirm(it)) },
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                                                    )
                                                ) {
                                                    Text(
                                                        text = "Yes",
                                                        style = MaterialTheme.typography.titleSmall
                                                    )
                                                }
                                            },
                                            dismissButton = {
                                                Button(
                                                    onClick = { viewModel.onEvent(CreateVacationUserEvent.OnAlertDialogDismiss) },
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                                                    )
                                                ) {
                                                    Text(
                                                        text = "No",
                                                        style = MaterialTheme.typography.titleSmall
                                                    )
                                                }
                                            },
                                            title = {
                                                Text(
                                                    text = "Your previous data will be lost, are you sure?",
                                                    style = MaterialTheme.typography.bodyLarge
                                                )
                                            },
                                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                                            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else{
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Loading...")
            }
        }

    }
    BackHandler(enabled = pagerState.currentPage == 1) {
        coroutineScope.launch {
            pagerState.animateScrollToPage(0)
        }
    }
}