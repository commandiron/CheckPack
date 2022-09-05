package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay

@Composable
fun LoadingThreeDotAnimation(
    text: String,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    enableThreeDot: Boolean = true,
    delayBetweenDots: Long = 500
) {
    val dotText = remember { mutableStateOf("")}
    LaunchedEffect(key1 = Unit){
        while (enableThreeDot){
            delay(delayBetweenDots)
            dotText.value = "."
            delay(delayBetweenDots)
            dotText.value = ".."
            delay(delayBetweenDots)
            dotText.value = "..."
            delay(delayBetweenDots)
            dotText.value = ""
        }
    }
    Row {
        Text(text = dotText.value, color = backgroundColor)
        Text(text = text)
        Text(text = dotText.value)
    }

}