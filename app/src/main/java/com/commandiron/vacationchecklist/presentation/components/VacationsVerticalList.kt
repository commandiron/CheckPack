package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
    var selectedItem by remember { mutableStateOf<Vacation?>(null)}
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(3),
            userScrollEnabled = userScrollEnabled
        ){
            items(vacations){ vacation ->
                val isSelected = vacation == selectedItem
                VacationItem(
                    modifier = Modifier
                        .aspectRatio(0.67f)
                        .padding(spacing.spaceSmall)
                        .clickable {
                            if (selectable) {
                                selectedItem = vacation
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