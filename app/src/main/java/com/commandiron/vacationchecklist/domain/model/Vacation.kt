package com.commandiron.vacationchecklist.domain.model

data class Vacation(
    val id: Int,
    val name: String,
    val iconDrawable: Int,
    val checklistItems: List<ChecklistItem>
)
