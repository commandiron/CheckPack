package com.commandiron.vacationchecklist.presentation.checklist.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.commandiron.vacationchecklist.ui.theme.importantBorderColor
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
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer
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
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer
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
                disablePastDateTime = true,
                textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                selectorColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.75f),
                selectorBorder = BorderStroke(1.dp, importantBorderColor)
            ) {
                snappedDateTime.value = it
            }
        },
        onDismissRequest = onDismiss,
        containerColor = MaterialTheme.colorScheme.primary,
        titleContentColor = MaterialTheme.colorScheme.onPrimary
    )
}