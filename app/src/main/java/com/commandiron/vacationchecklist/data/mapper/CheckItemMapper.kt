package com.commandiron.vacationchecklist.data.mapper

import com.commandiron.vacationchecklist.data.local.entity.CheckItemEntity
import com.commandiron.vacationchecklist.domain.model.CheckItem

fun CheckItemEntity.toCheckItem(): CheckItem {
    return CheckItem(
        id = id,
        name = name,
        isChecked = isChecked,
        isMarked = isMarked,
        iconDrawable = iconDrawable,
        importanceLevel = intToImportanceLevel(importanceLevel),
        gender = gender,
        category = category,
        vacationType = vacationType
    )
}

fun CheckItem.toCheckItemEntity(): CheckItemEntity {
    return CheckItemEntity(
        id = id,
        name = name,
        isChecked = isChecked,
        isMarked = isMarked,
        iconDrawable = iconDrawable,
        importanceLevel = importanceLevelToInt(importanceLevel),
        gender = gender,
        category = category,
        vacationType = vacationType
    )
}

private fun importanceLevelToInt(importanceLevel: CheckItem.ImportanceLevel): Int {
    return when(importanceLevel){
        CheckItem.ImportanceLevel.MUST -> 0
        CheckItem.ImportanceLevel.OPTIONAL -> 1
    }
}

private fun intToImportanceLevel(importanceLevel: Int): CheckItem.ImportanceLevel {
    return when(importanceLevel){
        0 -> CheckItem.ImportanceLevel.MUST
        1 -> CheckItem.ImportanceLevel.OPTIONAL
        else -> CheckItem.ImportanceLevel.MUST
    }
}