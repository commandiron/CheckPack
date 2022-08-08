package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingBarAnimation(
    modifier: Modifier = Modifier,
    thickness: Dp = 16.dp,
    fractionOfWidth: Float = 0.64f,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    fillColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
    borderColor: Color = MaterialTheme.colorScheme.primaryContainer,
    loadingBarDurationMillis: Int = 5000
) {
    val loadingBarProgress = remember {
        Animatable(0f)
    }
    var canvasWidth by remember { mutableStateOf(0f)}
    LaunchedEffect(key1 = Unit){
        loadingBarProgress.animateTo(
            targetValue = canvasWidth,
            animationSpec = tween(
                durationMillis = loadingBarDurationMillis,
                easing = LinearEasing
            )
        )
    }
    Surface(
        modifier = modifier
            .height(thickness)
            .fillMaxWidth(fractionOfWidth),
        color = backgroundColor,
        shape = RoundedCornerShape(thickness),
        border = BorderStroke(thickness / 8, borderColor)
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize(),
            onDraw = {
                canvasWidth = size.width
                val canvasHeight = size.height
                drawRect(
                    color = fillColor,
                    topLeft = Offset(0f, 0f),
                    size = Size(loadingBarProgress.value, canvasHeight)
                )
            }
        )
    }
}
