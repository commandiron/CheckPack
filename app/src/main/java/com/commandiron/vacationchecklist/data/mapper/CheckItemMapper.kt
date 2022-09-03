package com.commandiron.vacationchecklist.data.mapper

import com.commandiron.vacationchecklist.data.local.entity.CheckItemEntity
import com.commandiron.vacationchecklist.domain.model.CheckItem

fun CheckItemEntity.toCheckItem(): CheckItem {
    return CheckItem(
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

fun CheckItem.toCheckItemEntity(): CheckItemEntity {
    return CheckItemEntity(
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