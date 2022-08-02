package com.commandiron.vacationchecklist.domain.model

import androidx.annotation.DrawableRes
import com.commandiron.vacationchecklist.R

data class Vacation(
    val id: Int,
    val name: String,
    val iconDrawable: Int,
    val checklistItems: List<ChecklistItem>
)
