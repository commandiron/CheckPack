package com.commandiron.vacationchecklist.presentation.add_vacation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.vacationchecklist.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddVacationViewModel @Inject constructor(
): ViewModel() {

    var state by mutableStateOf(AddVacationState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(userEvent: AddVacationUserEvent) {
        when (userEvent) {
            is AddVacationUserEvent.OnSelect -> {
                state = state.copy(
                    selectedVacation = userEvent.vacation
                )
            }
            is AddVacationUserEvent.OnNameChange -> {
                state = state.copy(
                    selectedVacation = state.selectedVacation?.copy(
                        name = userEvent.text
                    )
                )
            }
            AddVacationUserEvent.OnFinish -> {

            }
        }
    }

    private fun sendUiEvent(uiEvent: UiEvent){
        viewModelScope.launch() {
            _uiEvent.send(uiEvent)
        }
    }
}