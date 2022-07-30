package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun CustomTextButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ),
    onClick:() -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = buttonColors
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }

}