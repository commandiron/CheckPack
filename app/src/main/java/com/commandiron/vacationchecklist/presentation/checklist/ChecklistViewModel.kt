package com.commandiron.vacationchecklist.presentation.checklist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.vacationchecklist.domain.preferences.Preferences
import com.commandiron.vacationchecklist.domain.use_cases.UseCases
import com.commandiron.vacationchecklist.util.Response
import com.commandiron.vacationchecklist.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChecklistViewModel @Inject constructor(
    private val useCases: UseCases,
    private val preferences: Preferences
): ViewModel() {

    var state by mutableStateOf(ChecklistState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        getVacation()
    }

    fun onEvent(userEvent: ChecklistUserEvent) {
        when (userEvent) {
            is ChecklistUserEvent.OnCheck -> {
                state.activeVacation?.let { vacation ->
                    state = state.copy(
                        activeVacation = vacation.copy(
                            checklistItems = vacation.checklistItems.toMutableList().also {
                                it[userEvent.index] = it[userEvent.index].copy(
                                    isChecked = !it[userEvent.index].isChecked
                                )

                            }
                        )
                    )
                    calculateCheckCount()
                    createVacation()
                }
            }
            ChecklistUserEvent.OnChecklistCompleteBack -> {
                state = state.copy(
                    isChecklistCompeted = false
                )
            }
            ChecklistUserEvent.OnGridViewClick -> {
                state = state.copy(
                    gridViewEnabled = true
                )
            }
            ChecklistUserEvent.OnListViewClick -> {
                state = state.copy(
                    gridViewEnabled = false
                )
            }
            is ChecklistUserEvent.OnSliderChange -> {
                if(userEvent.value > 0f && userEvent.value <= 0.25f ){
                    state = state.copy(
                        listScale = 1,
                        sliderValue = userEvent.value
                    )
                }
                if(userEvent.value > 0.25f && userEvent.value <= 0.75f ){
                    state = state.copy(
                        listScale = 2,
                        sliderValue = userEvent.value
                    )
                }
                if(userEvent.value > 0.75f && userEvent.value <= 1f ){
                    state = state.copy(
                        listScale = 3,
                        sliderValue = userEvent.value
                    )
                }
            }
        }
    }

    private fun getVacation() {
        viewModelScope.launch {
            useCases.getVacation(preferences.loadActiveVacationId()).collect{ response ->
                when(response){
                    is Response.Error -> {
                        state = state.copy(
                            isLoading = false
                        )
                    }
                    Response.Loading -> {
                        state = state.copy(
                            isLoading = true
                        )
                    }
                    is Response.Success -> {
                        state = state.copy(
                            activeVacation = response.data,
                            isLoading = false,
                            totalCheckCount = response.data.checklistItems.size
                        )
                        calculateCheckCount()
                    }
                }
            }
        }
    }

    private fun calculateCheckCount(){
        state.activeVacation?.let { vacation ->
            state = state.copy(
                checkCount = vacation.checklistItems.filter { it.isChecked }.size
            )
        }
        if(state.checkCount == state.totalCheckCount){
            state = state.copy(
                isChecklistCompeted = true
            )
        }
    }

    private fun createVacation() {
        viewModelScope.launch {
            state.activeVacation?.let {
                useCases.createVacation(it)
            }
        }
    }


    private fun sendUiEvent(uiEvent: UiEvent){
        viewModelScope.launch() {
            _uiEvent.send(uiEvent)
        }
    }
}