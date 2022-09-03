package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.domain.repository.Repository

class GetAllChecklistItems(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<ChecklistItem> {
        return repository.getAllChecklistItems()
    }
}