package com.commandiron.vacationchecklist.presentation.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.commandiron.vacationchecklist.util.Strings

@Composable
fun CustomAlertDialog(
    title: String,
    onDismiss:() -> Unit,
    onConfirm:() -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                onClick = onConfirm,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer
                )
            ) {
                Text(
                    text = Strings.English.YES,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer
                )
            ) {
                Text(
                    text = Strings.English.NO,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
    )
}