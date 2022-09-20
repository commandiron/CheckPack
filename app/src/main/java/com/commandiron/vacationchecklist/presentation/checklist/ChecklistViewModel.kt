package com.commandiron.vacationchecklist.presentation.checklist

import android.os.Build
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.vacationchecklist.R
import com.commandiron.vacationchecklist.domain.model.vacations
import com.commandiron.vacationchecklist.domain.preferences.Preferences
import com.commandiron.vacationchecklist.domain.use_cases.UseCases
import com.commandiron.vacationchecklist.util.UiEvent
import com.commandiron.vacationchecklist.util.UiText
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

    private val uiTextChannel = Channel<UiText>()
    val uiText = uiTextChannel.receiveAsFlow()

    var state by mutableStateOf(ChecklistState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        loadSettings()
        getActiveVacation()
        getChecklistItems()
    }

    fun onEvent(userEvent: ChecklistUserEvent) {
        when (userEvent) {
            is ChecklistUserEvent.OnCheck -> {
                if(!userEvent.checkedItem.isMarked){
                    if(state.doubleCheckEnabled){
                        if(userEvent.checkedItem.isChecked){
                            state = state.copy(
                                checkedItem = userEvent.checkedItem
                            )
                            check()
                        }else{
                            state = state.copy(
                                showCheckAlertDialog = true,
                                checkedItem = userEvent.checkedItem
                            )
                        }
                    }else{
                        state = state.copy(
                            checkedItem = userEvent.checkedItem
                        )
                        check()
                    }
                }
            }
            is ChecklistUserEvent.OnCheckAlertDialogConfirm -> {
                state = state.copy(
                    showCheckAlertDialog = false
                )
                check()
            }
            ChecklistUserEvent.OnCheckAlertDialogDismiss -> {
                state = state.copy(
                    showCheckAlertDialog = false
                )
            }

            is ChecklistUserEvent.OnMark -> {
                state = state.copy(
                    showMarkAlertDialog = true,
                    markedItem = userEvent.markedItem,
                )
            }
            ChecklistUserEvent.OnMarkAlertDialogConfirm -> {
                state = state.copy(
                    showMarkAlertDialog = false,
                    showSetAlarmAlertDialog = false,
                )
                mark()
            }
            ChecklistUserEvent.OnMarkAlertDialogDismiss -> {
                state = state.copy(
                    showMarkAlertDialog = false,
                    showSetAlarmAlertDialog = false
                )
            }
            ChecklistUserEvent.OnSetAlarm -> {
                state = state.copy(
                    showMarkAlertDialog = false
                )
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    state = state.copy(
                        showSetAlarmAlertDialog = true
                    )
                }else{
                    sendUiEvent(
                        UiEvent.ShowSnackbar(
                            UiText.StringResource(R.string.please_update_your_android_version),
                        )
                    )
                    mark()
                }
            }
            is ChecklistUserEvent.OnSetAlarmAlertDialogConfirm -> {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    useCases.setAlarm(
                        notificationTitle = "Checklist",
                        notificationDesc = state.markedItem?.name ?: "",
                        time = userEvent.dateTime
                    )
                    state = state.copy(
                        showSetAlarmAlertDialog = false
                    )
                    sendUiEvent(UiEvent.ShowSnackbar(UiText.StringResource(R.string.we_set_your_alarm)))
                    mark()
                }
            }
            ChecklistUserEvent.OnSetAlarmAlertDialogDismiss -> {
                state = state.copy(
                    showSetAlarmAlertDialog = false
                )
                mark()
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
            is ChecklistUserEvent.OnScrollCompleted -> {
                preferences.saveListFirstVisibleItemIndex(userEvent.firstVisibleItemIndex)
            }
            ChecklistUserEvent.OnChecklistCompleteBack -> {
                state = state.copy(
                    isChecklistCompeted = false
                )
            }
        }
    }

    private fun getActiveVacation() {
        state = state.copy(
            activeVacation = vacations.find { it.id ==  preferences.loadActiveVacationId()}
        )
    }

    private fun getChecklistItems() {
        viewModelScope.launch {
            state = state.copy(
                checkItems = useCases.getAllCheckItems()
            )
            calculateCheckCount()
        }
    }

    private fun loadSettings() {
        state = state.copy(
            firstVisibleItemIndex = preferences.loadListFirstVisibleItemIndex(),
            doubleCheckEnabled = preferences.loadShouldDoubleCheck(),
            gridViewEnabled = preferences.loadShouldShowGridView(),
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

    private fun check(){
        state.checkedItem?.let { checkedItem ->
            state = state.copy(
                checkItems = state.checkItems?.toMutableList()?.also {
                    it[it.indexOf(checkedItem)] = it[it.indexOf(checkedItem)].copy(
                        isChecked = !it[it.indexOf(checkedItem)].isChecked
                    )
                }
            )
            viewModelScope.launch {
                useCases.insertCheckItem(checkedItem.copy(isChecked = !checkedItem.isChecked))
            }
            calculateCheckCount()
        }
    }

    private fun mark(){
        state.markedItem?.let { markedItem ->
            state = state.copy(
                checkItems = state.checkItems?.toMutableList()?.also {
                    it[it.indexOf(markedItem)] = it[it.indexOf(markedItem)].copy(
                        isMarked = !it[it.indexOf(markedItem)].isMarked,
                        isChecked = false
                    )
                }
            )
            viewModelScope.launch {
                useCases.insertCheckItem(markedItem.copy(isMarked = !markedItem.isMarked, isChecked = false))
            }
        }
        calculateCheckCount()
    }

    private fun calculateCheckCount(){
        state.checkItems?.let { checkItems ->
            state = state.copy(
                totalCheckCount = checkItems.size,
                checkCount = checkItems.filter { it.isChecked }.size
            )
        }
        if(state.checkCount == state.totalCheckCount){
            state = state.copy(
                isChecklistCompeted = true
            )
        }
        state = state.copy(
            checkedItem = null
        )
    }

    private fun sendUiEvent(uiEvent: UiEvent){
        viewModelScope.launch() {
            _uiEvent.send(uiEvent)
        }
    }
}