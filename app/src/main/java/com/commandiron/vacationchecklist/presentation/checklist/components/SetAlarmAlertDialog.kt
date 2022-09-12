package com.commandiron.vacationchecklist.presentation.checklist.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.commandiron.wheel_picker_compose.WheelDateTimePicker
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetAlarmAlertDialog(
    title: String,
    confirmButtonText: String,
    dismissButtonText: String,
    onDismiss: () -> Unit,
    onConfirm: (LocalDateTime) -> Unit,
) {
    val snappedDateTime = remember { mutableStateOf(LocalDateTime.now())}
    AlertDialog(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm(snappedDateTime.value)
                },
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
            WheelDateTimePicker(
                disablePastDateTime = true
            ) {
                snappedDateTime.value = it
            }
        },
        onDismissRequest = onDismiss,
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        titleContentColor = MaterialTheme.colorScheme.primary
    )
}