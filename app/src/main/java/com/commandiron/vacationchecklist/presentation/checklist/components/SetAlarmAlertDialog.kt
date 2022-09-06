package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.commandiron.vacationchecklist.ui.theme.importantContainerColor

@Composable
fun SetAlarmAlertDialog(
    title: String,
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
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(
                    text = "Confirm",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(
                    text = "Dismiss",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        },
        onDismissRequest = onDismiss,
        containerColor = importantContainerColor,
        titleContentColor = MaterialTheme.colorScheme.primaryContainer
    )
}