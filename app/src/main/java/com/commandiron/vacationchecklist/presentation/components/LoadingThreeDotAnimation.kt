package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay

@Composable
fun LoadingThreeDotAnimation(
    text: String,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    enableThreeDot: Boolean = true,
    delayBetweenDots: Long = 500
) {
    var dotText by remember { mutableStateOf("")}
    LaunchedEffect(key1 = Unit){
        while (enableThreeDot){
            delay(delayBetweenDots)
            dotText = "."
            delay(delayBetweenDots)
            dotText = ".."
            delay(delayBetweenDots)
            dotText = "..."
            delay(delayBetweenDots)
            dotText = ""
        }
    }
    Row {
        Text(text = dotText, color = backgroundColor)
        Text(text = text)
        Text(text = dotText)
    }

}