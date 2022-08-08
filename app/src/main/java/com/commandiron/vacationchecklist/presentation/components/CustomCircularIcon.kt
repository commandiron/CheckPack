package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomCircularIcon(
    modifier: Modifier = Modifier,
    surfaceShape: Shape = CircleShape,
    surfaceColor: Color = Color.White,
    iconPadding: Dp = 0.dp,
    iconDrawable: Int,
) {
    Surface(
        modifier = modifier,
        shape = surfaceShape,
        color = surfaceColor
    ) {
        Icon(
            modifier = Modifier.padding(iconPadding),
            painter = painterResource(iconDrawable),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}
