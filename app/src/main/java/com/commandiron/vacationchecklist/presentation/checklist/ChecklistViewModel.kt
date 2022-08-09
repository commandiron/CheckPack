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
        loadSettings()
        getVacation()
    }

    fun onEvent(userEvent: ChecklistUserEvent) {
        when (userEvent) {
            is ChecklistUserEvent.OnCheck -> {
                if(state.doubleCheckEnabled){
                    if(userEvent.checklistItem.isChecked){
                        state = state.copy(
                            selectedIndex = userEvent.index
                        )
                        check()
                    }else{
                        state = state.copy(
                            showAlertDialog = true,
                            selectedIndex = userEvent.index
                        )
                    }

                }else{
                    state = state.copy(
                        selectedIndex = userEvent.index
                    )
                    check()
                }
            }
            ChecklistUserEvent.OnChecklistCompleteBack -> {
                state = state.copy(
                    isChecklistCompeted = false
                )
            }
            ChecklistUserEvent.OnGridViewClick -> {
                preferences.saveShouldShowGridView(true)
                loadSettings()

            }
            ChecklistUserEvent.OnListViewClick -> {
                preferences.saveShouldShowGridView(false)
                loadSettings()
            }
            is ChecklistUserEvent.OnSliderChange -> {
                if(userEvent.value > 0f && userEvent.value <= 0.25f ){
                    state = state.copy(
                        sliderValue = userEvent.value,
                        listScale = 1
                    )
                }
                if(userEvent.value > 0.25f && userEvent.value <= 0.75f ){
                    state = state.copy(
                        sliderValue = userEvent.value,
                        listScale = 2
                    )
                }
                if(userEvent.value > 0.75f && userEvent.value <= 1f ){
                    state = state.copy(
                        sliderValue = userEvent.value,
                        listScale = 3
                    )
                }
            }
            ChecklistUserEvent.OnSliderValueChangeFinished -> {
                preferences.saveListScale(state.listScale)
            }
            is ChecklistUserEvent.OnAlertDialogConfirm -> {
                state = state.copy(
                    showAlertDialog = false
                )
                check()
            }
            ChecklistUserEvent.OnAlertDialogDismiss -> {
                state = state.copy(
                    showAlertDialog = false
                )
            }

        }
    }

    private fun loadSettings() {
        state = state.copy(
            doubleCheckEnabled = preferences.loadShouldDoubleCheck(),
            gridViewEnabled = preferences.loadShouldShowGridView(),
            listScale = preferences.loadListScale()
        )
        state = state.copy(
            sliderValue = when(state.listScale){
                1 -> 0f
                2 -> 0.5f
                3 -> 1f
                else -> 0.5f
            }
        )
    }

    private fun check(){
        state.activeVacation?.let { vacation ->
            state.selectedIndex?.let { selectedIndex ->
                state = state.copy(
                    activeVacation = vacation.copy(
                        checklistItems = vacation.checklistItems.toMutableList().also {
                            it[selectedIndex] = it[selectedIndex].copy(
                                isChecked = !it[selectedIndex].isChecked
                            )

                        }
                    )
                )
                calculateCheckCount()
                createVacation()
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