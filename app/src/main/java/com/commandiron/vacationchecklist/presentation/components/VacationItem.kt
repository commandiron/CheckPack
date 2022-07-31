package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.presentation.model.Vacation
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun VacationItem(
    modifier: Modifier = Modifier,
    showTitle: Boolean = true,
    isSelected: Boolean = false,
    vacation: Vacation,
    iconPadding: Dp = 0.dp
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VacationIcon(
            modifier = Modifier
                .aspectRatio(1f)
                .weight(2f)
                .border(
                    width = 2.dp,
                    brush = if (isSelected)
                        Brush.linearGradient(
                            listOf(
                                Color(0xFFA5BADE),
                                Color(0xFFBCEBE3)
                            )
                        )
                        else Brush.linearGradient(
                            listOf(
                                Color.White,
                                Color.White
                            )
                        ),
                    shape = CircleShape
            ),
            iconPadding = iconPadding,
            iconDrawable = vacation.iconDrawable
        )
        if(showTitle) {
            Spacer(modifier = Modifier.height(spacing.spaceSmall))
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
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
}