package com.commandiron.vacationchecklist.domain.use_cases

class UseCases(
    val getAllVacations: GetAllVacations,
    val insertAllChecklistItems: InsertAllChecklistItems,
    val deleteAllChecklistItems: DeleteAllChecklistItems,
    val getAllChecklistItems: GetAllChecklistItems,
    val insertChecklistItem: InsertChecklistItem
)