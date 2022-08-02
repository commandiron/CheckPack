package com.commandiron.vacationchecklist.presentation.checklist

sealed class ChecklistUserEvent{
    data class OnCheck(val index: Int): ChecklistUserEvent()
}
