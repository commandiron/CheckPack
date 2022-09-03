package com.commandiron.vacationchecklist.domain.use_cases

class UseCases(
    val getAllVacations: GetAllVacations,
    val insertAllChecklistItems: InsertAllChecklistItems,
    val getChecklistItems: GetChecklistItems,
    val insertChecklistItem: InsertChecklistItem
)