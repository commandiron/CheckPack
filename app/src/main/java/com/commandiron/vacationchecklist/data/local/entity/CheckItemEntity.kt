package com.commandiron.vacationchecklist.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CheckItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val isChecked: Boolean,
    val isMarked: Boolean,
    val iconDrawable: Int,
    val importanceLevel: Int,
    val gender: Int,
    val category: Int,
    val vacationType: Int
)