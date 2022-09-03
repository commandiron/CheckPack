package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.domain.model.CheckItem
import com.commandiron.vacationchecklist.domain.repository.Repository

class GetAllCheckItems(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<CheckItem> {
        return repository.getAllCheckItems()
    }
}