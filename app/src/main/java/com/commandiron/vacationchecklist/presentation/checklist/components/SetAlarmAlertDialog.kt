package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SetAlarmAlertDialog(
    title: String,
    confirmButtonText: String,
    dismissButtonText: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    AlertDialog(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        confirmButton = {
            Button(
                onClick = onConfirm,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = confirmButtonText,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = dismissButtonText,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        },
        text = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Red)
            ){

            }
        },
        onDismissRequest = onDismiss,
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        titleContentColor = MaterialTheme.colorScheme.primary
    )
}