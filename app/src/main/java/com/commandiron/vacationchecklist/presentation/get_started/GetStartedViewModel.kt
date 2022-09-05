package com.commandiron.vacationchecklist.presentation.get_started

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.vacationchecklist.domain.preferences.Preferences
import com.commandiron.vacationchecklist.domain.use_cases.UseCases
import com.commandiron.vacationchecklist.navigation.NavigationItem
import com.commandiron.vacationchecklist.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetStartedViewModel @Inject constructor(
    private val useCases: UseCases,
    private val preferences: Preferences
): ViewModel() {

    var state by mutableStateOf(GetStartedState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        viewModelScope.launch {
            if(useCases.getAllCheckItems().isNotEmpty()){
                sendUiEvent(UiEvent.Navigate(NavigationItem.ChecklistScreen.route))
            }
        }
        state = state.copy(
            fakeLoading = false,
            vacations = useCases.getAllVacations()
        )
    }

    fun onEvent(userEvent: GetStartedUserEvent) {
        when (userEvent) {
            is GetStartedUserEvent.OnSelect -> {
                state = state.copy(
                    selectedVacation = userEvent.vacation
                )
            }
            is GetStartedUserEvent.OnNameChange -> {
                state = state.copy(
                    selectedVacation = state.selectedVacation?.copy(
                        name = userEvent.text
                    )
                )
            }
            is GetStartedUserEvent.OnFinish -> {
                state.selectedVacation?.let {
                    viewModelScope.launch {
                        useCases.deleteAllCheckItems()
                        useCases.insertAllCheckItems(it)
                    }
                    preferences.saveActiveVacationId(userEvent.vacation.id)
                    viewModelScope.launch {
                        state = state.copy(
                            fakeLoading = true
                        )
                        delay(state.fakeLoadingDelay)
                        sendUiEvent(UiEvent.Navigate(NavigationItem.ChecklistScreen.route))
                    }
                }
            }
        }
    }

    private fun sendUiEvent(uiEvent: UiEvent){
        viewModelScope.launch() {
            _uiEvent.send(uiEvent)
        }
    }
}