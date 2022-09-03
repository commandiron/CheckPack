package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.domain.repository.Repository

class DeleteAllCheckItems(
    private val repository: Repository
) {
    suspend operator fun invoke(){
        repository.deleteAllCheckItems()
    }
}