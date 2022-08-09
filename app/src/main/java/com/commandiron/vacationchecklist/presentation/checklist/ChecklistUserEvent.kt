package com.commandiron.vacationchecklist.presentation.checklist

sealed class ChecklistUserEvent{
    data class OnCheck(val index: Int): ChecklistUserEvent()
    object OnAlertDialogDismiss : ChecklistUserEvent()
    object OnAlertDialogConfirm : ChecklistUserEvent()
    object OnChecklistCompleteBack: ChecklistUserEvent()
    object OnListViewClick: ChecklistUserEvent()
    object OnGridViewClick: ChecklistUserEvent()
    data class OnSliderChange(val value: Float): ChecklistUserEvent()
    object OnSliderValueChangeFinished: ChecklistUserEvent()
}
