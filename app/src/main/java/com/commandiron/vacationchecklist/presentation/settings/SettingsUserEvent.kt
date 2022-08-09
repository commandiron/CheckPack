package com.commandiron.vacationchecklist.presentation.settings

sealed class SettingsUserEvent{
    object OnSwitchCheckedChange: SettingsUserEvent()
}
