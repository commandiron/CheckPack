package com.commandiron.vacationchecklist.presentation.checklist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.vacationchecklist.domain.model.ChecklistItem
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
                        check(userEvent.checklistItem)
                    }else{
                        state = state.copy(
                            showAlertDialog = true,
                            checkListItemForDialog = userEvent.checklistItem
                        )
                    }

                }else{
                    check(userEvent.checklistItem)
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
                state = state.copy(
                    sliderValue = userEvent.value,
                    gridColumnCount = when(userEvent.value){
                        0f -> 5
                        0.25f -> 4
                        0.50f -> 3
                        0.75f -> 2
                        1f -> 1
                        else -> 3
                    },
                    listItemHeightValue =  when(userEvent.value){
                        0f -> 24f
                        0.25f -> 32f
                        0.50f -> 64f
                        0.75f -> 96f
                        1f -> 128f
                        else -> 64f
                    }
                )
            }
            ChecklistUserEvent.OnSliderValueChangeFinished -> {
                preferences.saveSliderValue(state.sliderValue)
            }
            is ChecklistUserEvent.OnAlertDialogConfirm -> {
                state = state.copy(
                    showAlertDialog = false
                )
                state.checkListItemForDialog?.let {
                    check(it)
                }
            }
            ChecklistUserEvent.OnAlertDialogDismiss -> {
                state = state.copy(
                    showAlertDialog = false
                )
            }
            is ChecklistUserEvent.OnAddAlarmClick -> {
                //Burda alarm kurulacak.
            }
        }
    }

    private fun loadSettings() {
        state = state.copy(
            doubleCheckEnabled = preferences.loadShouldDoubleCheck(),
            gridViewEnabled = preferences.loadShouldShowGridView()
        )
        state = state.copy(
            sliderValue = preferences.loadSliderValue()
        )
        state = state.copy(
            gridColumnCount = when(state.sliderValue){
                0f -> 5
                0.25f -> 4
                0.50f -> 3
                0.75f -> 2
                1f -> 1
                else -> 3
            },
            listItemHeightValue =  when(state.sliderValue){
                0f -> 24f
                0.25f -> 32f
                0.50f -> 64f
                0.75f -> 96f
                1f -> 128f
                else -> 64f
            }
        )
    }

    private fun check(checklistItem: ChecklistItem){
        state.activeVacation?.let { vacation ->
            state = state.copy(
                activeVacation = vacation.copy(
                    checklistItems = vacation.checklistItems.toMutableList().also {
                        it[it.indexOf(checklistItem)] = it[it.indexOf(checklistItem)].copy(
                            isChecked = !it[it.indexOf(checklistItem)].isChecked
                        )
                    }
                )
            )
            calculateCheckCount()
            createVacation()
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