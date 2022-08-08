package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.commandiron.vacationchecklist.domain.model.Vacation
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
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
                        vacations = vacations, //Bu kısım domainden gelecek.
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
                                    text = "NEXT",
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
                                onValueChange = onVacationNameChange,
                                singleLine = true
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
                                    text = "FINISH",
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        if(showAlertDialog){
                            AlertDialog(
                                onDismissRequest = onAlertDismiss,
                                confirmButton = {
                                    Button(
                                        onClick = { onAlertConfirm(it) },
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
                                        onClick = onAlertDismiss,
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
                                        text = "Your previous checklist will be lost, are you sure?",
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