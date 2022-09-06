package com.commandiron.vacationchecklist.domain.use_cases

class UseCases(
    val getAllVacations: GetAllVacations,
    val insertAllCheckItems: InsertAllCheckItems,
    val deleteAllCheckItems: DeleteAllCheckItems,
    val getAllCheckItems: GetAllCheckItems,
    val insertCheckItem: InsertCheckItem,
    val setAlarm: SetAlarm
)