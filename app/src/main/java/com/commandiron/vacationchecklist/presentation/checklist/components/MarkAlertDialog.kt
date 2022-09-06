package com.commandiron.vacationchecklist.presentation.checklist.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.ui.theme.importantContainerColor

@Composable
fun MarkAlertDialog(
    title: String,
    firstButtonText: String,
    secondButtonText: String,
    setAlarmButtonEnabled: Boolean = false,
    onSetAlarm: () -> Unit,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
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
                    text = firstButtonText,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        },
        dismissButton = {
            Row() {
                if(setAlarmButtonEnabled){
                    Button(
                        onClick = onSetAlarm,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = importantContainerColor,
                            contentColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Text(
                            text = "Set Alarm",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                }
                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                    )
                ) {
                    Text(
                        text = secondButtonText,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
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