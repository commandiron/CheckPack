package com.commandiron.vacationchecklist.presentation.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Chip
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.*
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
                    checkedTrackColor = MaterialTheme.colorScheme.tertiaryContainer,
                    uncheckedThumbColor = MaterialTheme.colorScheme.tertiaryContainer,
                    uncheckedTrackColor = Color.White,
                    uncheckedBorderColor = MaterialTheme.colorScheme.tertiaryContainer
                )
            )
        }
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Divider(color = LocalContentColor.current.copy(alpha = 0.2f))
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
    }
}