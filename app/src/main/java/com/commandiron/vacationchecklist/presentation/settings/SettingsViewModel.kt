package com.commandiron.vacationchecklist.presentation.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.vacationchecklist.domain.preferences.Preferences
import com.commandiron.vacationchecklist.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    var state by mutableStateOf(SettingsState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        loadDoubleCheck()
    }

    fun onEvent(userEvent: SettingsUserEvent) {
        when (userEvent) {
            SettingsUserEvent.OnSwitchCheckedChange -> {
                saveDoubleCheck()
                loadDoubleCheck()
            }
        }
    }

    private fun loadDoubleCheck(){
        state = state.copy(
            switchChecked = preferences.loadShouldDoubleCheck()
        )
    }

    private fun saveDoubleCheck(){
        preferences.saveShouldDoubleCheck(!state.switchChecked)
    }

    private fun sendUiEvent(uiEvent: UiEvent){
        viewModelScope.launch() {
            _uiEvent.send(uiEvent)
        }
    }
}