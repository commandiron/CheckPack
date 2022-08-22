package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.commandiron.vacationchecklist.domain.model.Vacation
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.Strings.English.ENTER_VACATION_NAME
import com.commandiron.vacationchecklist.util.Strings.English.FINISH
import com.commandiron.vacationchecklist.util.Strings.English.NEXT
import com.commandiron.vacationchecklist.util.Strings.English.NO
import com.commandiron.vacationchecklist.util.Strings.English.YES
import com.commandiron.vacationchecklist.util.Strings.English.YOUR_PREVIOUS_CHECKLIST_WILL_BE_LOST_ARE_YOU_SURE
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@Composable
fun CreateVacationBody(
    pagerState: PagerState,
    vacations: List<Vacation>,
    onSelect: (Vacation) -> Unit,
    selectedVacation: Vacation?,
    nextButtonEnabled: Boolean = true,
    onNextClick: () -> Unit = {},
    onVacationNameChange: (String) -> Unit,
    onFinishClick: (Vacation) -> Unit,
    showAlertDialog: Boolean = false,
    onAlertDismiss: () -> Unit = {},
    onAlertConfirm: (Vacation) -> Unit = {}
) {
    val spacing = LocalSpacing.current
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
                        vacations = vacations,
                        onSelect = onSelect
                    )
                    if(nextButtonEnabled){
                        selectedVacation?.let {
                            Button(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                onClick = onNextClick,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer
                                )
                            ) {
                                Text(
                                    text = NEXT,
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
            1 -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    selectedVacation?.let {
                        Text(
                            text = ENTER_VACATION_NAME,
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
                            CustomTextField(
                                modifier = Modifier.fillMaxWidth(0.75f),
                                value = it.name,
                                onValueChange = onVacationNameChange
                            )
                            Spacer(modifier = Modifier.height(spacing.spaceLarge))
                            Button(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                onClick = { onFinishClick(it) },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer
                                )
                            ) {
                                Text(
                                    text = FINISH,
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        if(showAlertDialog){
                            CustomAlertDialog(
                                title = YOUR_PREVIOUS_CHECKLIST_WILL_BE_LOST_ARE_YOU_SURE,
                                onDismiss = onAlertDismiss,
                                onConfirm = { onAlertConfirm(it) }
                            )
                        }
                    }
                }
            }
        }
    }
}