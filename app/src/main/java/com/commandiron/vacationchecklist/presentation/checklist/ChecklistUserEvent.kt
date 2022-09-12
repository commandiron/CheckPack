package com.commandiron.vacationchecklist.presentation.checklist

import com.commandiron.vacationchecklist.domain.model.CheckItem
import java.time.LocalDateTime

sealed class ChecklistUserEvent{
    data class OnCheck(val checkedItem: CheckItem): ChecklistUserEvent()
    object OnCheckAlertDialogConfirm : ChecklistUserEvent()
    object OnCheckAlertDialogDismiss : ChecklistUserEvent()

    data class OnMark(val markedItem: CheckItem): ChecklistUserEvent()
    object OnMarkAlertDialogConfirm : ChecklistUserEvent()
    object OnMarkAlertDialogDismiss : ChecklistUserEvent()

    object OnSetAlarm : ChecklistUserEvent()
    data class OnSetAlarmAlertDialogConfirm(val dateTime: LocalDateTime) : ChecklistUserEvent()
    object OnSetAlarmAlertDialogDismiss : ChecklistUserEvent()

    object OnGridViewClick: ChecklistUserEvent()
    object OnListViewClick: ChecklistUserEvent()
    data class OnSliderChange(val value: Float): ChecklistUserEvent()
    object OnSliderValueChangeFinished: ChecklistUserEvent()
    data class OnScrollCompleted(val firstVisibleItemIndex: Int): ChecklistUserEvent()
    object OnChecklistCompleteBack: ChecklistUserEvent()
}
