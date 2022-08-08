package com.commandiron.vacationchecklist.presentation.checklist

import com.commandiron.vacationchecklist.domain.model.Vacation

data class ChecklistState(
    val activeVacation: Vacation? = null,
    val isLoading: Boolean = false,
    val checkCount: Int = 0,
    val totalCheckCount: Int = 0,
    val isChecklistCompeted: Boolean = false,
    val gridViewEnabled: Boolean = true,
    val listScale: Int = 2,
    val sliderValue: Float = 0.50f
)
