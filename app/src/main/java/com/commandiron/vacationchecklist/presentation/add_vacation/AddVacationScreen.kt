package com.commandiron.vacationchecklist.presentation.add_vacation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.vacationchecklist.presentation.add_vacation.components.AddVacationHeader
import com.commandiron.vacationchecklist.presentation.components.VacationItem
import com.commandiron.vacationchecklist.presentation.components.VacationsVerticalList
import com.commandiron.vacationchecklist.presentation.model.vacations
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AddVacationScreen(
    viewModel: AddVacationViewModel = hiltViewModel(),
) {
    val state = viewModel.state
    val spacing = LocalSpacing.current
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.defaultScreenPadding),
    ) {
        AddVacationHeader(
            modifier = Modifier.fillMaxWidth(),
            title = "Change Vacation",
            subTitle = "You can change vacation for generate checklist",
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Divider(color = LocalContentColor.current.copy(alpha = 0.2f))
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
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
                            vacations = vacations, //Bu kısım domainden gelecek.
                            onSelect = { viewModel.onEvent(AddVacationUserEvent.OnSelect(it)) }
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
                                    onValueChange = { viewModel.onEvent(AddVacationUserEvent.OnNameChange(it)) },
                                    singleLine = true
                                )
                                Spacer(modifier = Modifier.height(spacing.spaceLarge))
                                Button(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    onClick = { viewModel.onEvent(AddVacationUserEvent.OnFinish) },
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

                        }
                    }
                }
            }
        }
    }
    BackHandler(enabled = pagerState.currentPage == 1) {
        coroutineScope.launch {
            pagerState.animateScrollToPage(0)
        }
    }
}