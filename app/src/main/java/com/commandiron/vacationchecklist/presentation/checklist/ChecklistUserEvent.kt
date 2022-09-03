package com.commandiron.vacationchecklist.presentation.checklist

import com.commandiron.vacationchecklist.domain.model.ChecklistItem

sealed class ChecklistUserEvent{
    data class OnCheck(val checklistItem: ChecklistItem): ChecklistUserEvent()
    data class OnAddAlarmClick(val index: Int, val checklistItem: ChecklistItem): ChecklistUserEvent()
    object OnAlertDialogDismiss : ChecklistUserEvent()
    object OnAlertDialogConfirm : ChecklistUserEvent()
    object OnChecklistCompleteBack: ChecklistUserEvent()
    object OnListViewClick: ChecklistUserEvent()
    object OnGridViewClick: ChecklistUserEvent()
    data class OnSliderChange(val value: Float): ChecklistUserEvent()
    object OnSliderValueChangeFinished: ChecklistUserEvent()
}
