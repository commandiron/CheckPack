package com.commandiron.vacationchecklist.domain.repository

import com.commandiron.vacationchecklist.domain.model.ChecklistItem

interface Repository {
    suspend fun insertChecklistItems(checklistItems: List<ChecklistItem>)
    suspend fun getAllChecklistItems(): List<ChecklistItem>
}