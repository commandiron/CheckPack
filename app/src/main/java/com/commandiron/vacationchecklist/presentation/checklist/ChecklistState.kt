package com.commandiron.vacationchecklist.presentation.checklist

import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.domain.model.Vacation

data class ChecklistState(

    val checklistItems: List<ChecklistItem>? = null,
    val activeVacation: Vacation? = null,




    val doubleCheckEnabled: Boolean = false,
    val isLoading: Boolean = false,
    val showAlertDialog: Boolean = false,
    val checkListItemForDialog: ChecklistItem? = null,
    val checkCount: Int = 0,
    val totalCheckCount: Int = 0,
    val isChecklistCompeted: Boolean = false,
    val gridViewEnabled: Boolean = false,
    val sliderValue: Float = 0.5f,

    val gridColumnCount: Int = 3,
    val listItemHeightValue: Float = 64f,
)
