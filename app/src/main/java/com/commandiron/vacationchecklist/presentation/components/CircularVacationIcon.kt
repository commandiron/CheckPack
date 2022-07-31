package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircularVacationIcon(
    modifier: Modifier = Modifier,
    iconPadding: Dp = 0.dp,
    iconDrawable: Int,
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = Color.White
    ) {
        Icon(
            modifier = Modifier.padding(iconPadding),
            painter = painterResource(iconDrawable),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}
