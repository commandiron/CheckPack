package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.presentation.model.Vacation
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.NoRippleTheme

@Composable
fun VacationsVerticalList(
    modifier: Modifier = Modifier,
    vacations: List<Vacation>,
    selectable: Boolean = true,
    onSelect:(Vacation) -> Unit
) {
    val spacing = LocalSpacing.current
    var selectedItem by remember { mutableStateOf<Vacation?>(null)}
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(3)
        ){
            items(vacations){ vacation ->
                val isSelected = vacation == selectedItem
                Column(
                    modifier = Modifier
                        .aspectRatio(0.67f)
                        .padding(spacing.spaceMedium)
                        .clickable {
                            if (selectable) {
                                selectedItem = vacation
                                onSelect(vacation)
                            }
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(2f)
                            .border(
                                1.dp,
                                if(isSelected) Color.Blue else MaterialTheme.colorScheme.background,
                                CircleShape
                            ),
                        shape = CircleShape,
                        color = Color.White
                    ) {
                        Icon(
                            painter = painterResource(id = vacation.iconId),
                            contentDescription = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = vacation.name,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }
            item{
                Spacer(modifier = Modifier.height(spacing.spaceXXXLarge))
            }
        }
    }
}