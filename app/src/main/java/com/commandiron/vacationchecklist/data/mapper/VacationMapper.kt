package com.commandiron.vacationchecklist.data.mapper

import com.commandiron.vacationchecklist.data.local.entity.VacationEntity
import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.domain.model.Vacation
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun VacationEntity.toVacation(): Vacation {
    val gson = Gson()
    val listType = object : TypeToken<List<ChecklistItem>>() {}.type
    val checklistItemFromJson = gson.fromJson<List<ChecklistItem>>(checklistItems, listType)
    return Vacation(
        id = id,
        name = name,
        iconDrawable = iconDrawable,
        checklistItems = checklistItemFromJson
    )

}
fun Vacation.toVacationEntity(): VacationEntity {
    val gson = Gson()
    return VacationEntity(
        id = id,
        name = name,
        iconDrawable = iconDrawable,
        checklistItems = gson.toJson(checklistItems)
    )
}