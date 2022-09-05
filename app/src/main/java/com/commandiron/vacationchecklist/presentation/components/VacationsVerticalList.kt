package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.commandiron.vacationchecklist.domain.model.Vacation
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.NoRippleTheme

@Composable
fun VacationsVerticalList(
    modifier: Modifier = Modifier,
    userScrollEnabled: Boolean = false,
    vacations: List<Vacation>,
    selectable: Boolean = true,
    onSelect:(Vacation) -> Unit
) {
    val spacing = LocalSpacing.current
    val selectedItem = remember { mutableStateOf<Vacation?>(null)}
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(3),
            userScrollEnabled = userScrollEnabled
        ){
            items(vacations){ vacation ->
                val isSelected = vacation == selectedItem.value
                VacationItem(
                    modifier = Modifier
                        .aspectRatio(0.67f)
                        .padding(spacing.spaceSmall)
                        .clickable {
                            if (selectable) {
                                selectedItem.value = vacation
                                onSelect(vacation)
                            }
                        },
                    isSelected = isSelected,
                    vacation = vacation,
                    iconPadding = spacing.spaceSmall
                )
            }
        }
    }
}