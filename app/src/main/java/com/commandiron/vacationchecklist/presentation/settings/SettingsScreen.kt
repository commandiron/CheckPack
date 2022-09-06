package com.commandiron.vacationchecklist.presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.vacationchecklist.R
import com.commandiron.vacationchecklist.presentation.components.CustomHeader
import com.commandiron.vacationchecklist.util.LocalSpacing

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.defaultScreenPadding),
    ) {
        CustomHeader(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(R.string.settings)
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Divider(color = LocalContentColor.current.copy(alpha = 0.2f))
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.double_Check),
                style = MaterialTheme.typography.titleMedium
            )
            Switch(
                checked = state.switchChecked,
                onCheckedChange = { viewModel.onEvent(SettingsUserEvent.OnSwitchCheckedChange) },
                colors = SwitchDefaults.colors(
                    checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                    uncheckedThumbColor = MaterialTheme.colorScheme.primaryContainer,
                    uncheckedTrackColor = Color.White,
                    uncheckedBorderColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Divider(color = LocalContentColor.current.copy(alpha = 0.2f))
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
    }
}