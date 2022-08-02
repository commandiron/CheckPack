package com.commandiron.vacationchecklist.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VacationEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val iconDrawable: Int,
    val checklistItems: String
)
