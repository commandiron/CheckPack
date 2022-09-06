package com.commandiron.vacationchecklist.presentation.checklist

import com.commandiron.vacationchecklist.domain.model.CheckItem

sealed class ChecklistUserEvent{
    data class OnScrollCompleted(val firstVisibleItemIndex: Int): ChecklistUserEvent()
    data class OnCheck(val checkedItem: CheckItem): ChecklistUserEvent()
    data class OnMark(val markedItem: CheckItem): ChecklistUserEvent()

    object OnCheckAlertDialogDismiss : ChecklistUserEvent()
    object OnCheckAlertDialogConfirm : ChecklistUserEvent()

    object OnMarkAlertDialogDismiss : ChecklistUserEvent()
    object OnMarkAlertDialogConfirm : ChecklistUserEvent()

    object OnChecklistCompleteBack: ChecklistUserEvent()
    object OnListViewClick: ChecklistUserEvent()
    object OnGridViewClick: ChecklistUserEvent()
    data class OnSliderChange(val value: Float): ChecklistUserEvent()
    object OnSliderValueChangeFinished: ChecklistUserEvent()
}
