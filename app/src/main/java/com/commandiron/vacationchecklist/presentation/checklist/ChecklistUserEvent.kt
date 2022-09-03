package com.commandiron.vacationchecklist.presentation.checklist

import com.commandiron.vacationchecklist.domain.model.CheckItem

sealed class ChecklistUserEvent{
    data class OnCheck(val checkItem: CheckItem): ChecklistUserEvent()
    object OnAlertDialogDismiss : ChecklistUserEvent()
    object OnAlertDialogConfirm : ChecklistUserEvent()
    object OnChecklistCompleteBack: ChecklistUserEvent()
    object OnListViewClick: ChecklistUserEvent()
    object OnGridViewClick: ChecklistUserEvent()
    data class OnSliderChange(val value: Float): ChecklistUserEvent()
    object OnSliderValueChangeFinished: ChecklistUserEvent()
}
