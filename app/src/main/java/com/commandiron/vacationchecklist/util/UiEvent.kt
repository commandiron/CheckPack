package com.commandiron.vacationchecklist.util

sealed class UiEvent {
    data class Navigate(val route: String): UiEvent()
    data class ShowSnackbar(val uiText: UiText): UiEvent()
}