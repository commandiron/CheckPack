package com.commandiron.vacationchecklist.data.mapper

import com.commandiron.vacationchecklist.data.local.entity.ChecklistItemEntity
import com.commandiron.vacationchecklist.domain.model.ChecklistItem

fun ChecklistItemEntity.toChecklistItem(): ChecklistItem {
    return ChecklistItem(
        id = id,
        name = name,
        isChecked = isChecked,
        iconDrawable = iconDrawable,
        importanceLevel = importanceLevel,
        gender = gender,
        category = category,
        vacationType = vacationType
    )
}

fun ChecklistItem.toChecklistItemEntity(): ChecklistItemEntity {
    return ChecklistItemEntity(
        id = id,
        name = name,
        isChecked = isChecked,
        iconDrawable = iconDrawable,
        importanceLevel = importanceLevel,
        gender = gender,
        category = category,
        vacationType = vacationType
    )
}