package com.commandiron.vacationchecklist.presentation.checklist

import com.commandiron.vacationchecklist.domain.model.CheckItem
import com.commandiron.vacationchecklist.domain.model.Vacation

data class ChecklistState(
    val activeVacation: Vacation? = null,
    val checkItems: List<CheckItem>? = null,
    val checkedItem: CheckItem? = null,
    val markedItem: CheckItem? = null,
    val firstVisibleItemIndex: Int = 0,
    val doubleCheckEnabled: Boolean = false,
    val isLoading: Boolean = false,
    val showCheckAlertDialog: Boolean = false,
    val showMarkAlertDialog: Boolean = false,
    val checkCount: Int = 0,
    val totalCheckCount: Int = 0,
    val isChecklistCompeted: Boolean = false,
    val gridViewEnabled: Boolean = false,
    val sliderValue: Float = 0.5f,
    val gridColumnCount: Int = 3,
    val listItemHeightValue: Float = 64f,
)
