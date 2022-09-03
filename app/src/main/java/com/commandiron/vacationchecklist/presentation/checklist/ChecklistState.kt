package com.commandiron.vacationchecklist.presentation.checklist

import com.commandiron.vacationchecklist.domain.model.Vacation

data class ChecklistState(
    val activeVacation: Vacation? = null,
    val doubleCheckEnabled: Boolean = false,
    val selectedIndex: Int? = null,
    val isLoading: Boolean = false,
    val showAlertDialog: Boolean = false,
    val checkCount: Int = 0,
    val totalCheckCount: Int = 0,
    val isChecklistCompeted: Boolean = false,
    val gridViewEnabled: Boolean = false,
    val sliderValue: Float = 0.5f,

    val gridColumnCount: Int = 3,
    val listItemHeightValue: Float = 64f,
)
