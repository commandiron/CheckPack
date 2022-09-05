package com.commandiron.vacationchecklist.presentation.components


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.R
import com.commandiron.vacationchecklist.domain.model.Vacation
import com.commandiron.vacationchecklist.util.LocalSpacing
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
                                    text = stringResource(R.string.next),
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
                            text = stringResource(R.string.enter_vacation_name),
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
                        Column(
                            modifier = Modifier.weight(2f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CustomTextField(
                                modifier = Modifier.fillMaxWidth(0.75f),
                                value = it.name,
                                onValueChange = onVacationNameChange
                            )
                            Spacer(modifier = Modifier.height(spacing.spaceLarge))
                            CustomButton(text = stringResource(R.string.finish)) {
                                onFinishClick(it)
                            }
                        }
                        if(showAlertDialog){
                            CustomAlertDialog(
                                title = stringResource(R.string.your_previous_checklist_will_be_lost_are_you_sure),
                                firstButtonText = stringResource(R.string.yes),
                                secondButtonText = stringResource(R.string.no),
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