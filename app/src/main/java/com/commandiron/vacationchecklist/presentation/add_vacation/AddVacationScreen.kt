package com.commandiron.vacationchecklist.presentation.add_vacation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.commandiron.vacationchecklist.presentation.add_vacation.components.AddVacationHeader
import com.commandiron.vacationchecklist.presentation.components.CustomTextButton
import com.commandiron.vacationchecklist.presentation.components.VacationsVerticalList
import com.commandiron.vacationchecklist.presentation.model.vacations
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AddVacationScreen() {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.defaultScreenPadding),
    ) {
        AddVacationHeader(
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Divider(color = LocalContentColor.current.copy(alpha = 0.2f))
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        HorizontalPager(count = 2) {
            when(currentPage){
                0 -> {
                    VacationsVerticalList(
                        vacations = vacations, //Bu kısım domainden gelecek.
                    ){

                    }
                    CustomTextButton(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(spacing.bottomNavigationHeight)
                            .align(Alignment.CenterHorizontally),
                        text = "SELECT"
                    ) {

                    }
                }
                1 -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Name")
                    }
                }
            }

        }

    }
}