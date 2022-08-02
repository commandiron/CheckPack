package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.domain.model.Vacation
import com.commandiron.vacationchecklist.domain.repository.Repository

class CreateVacation(
    private val repository: Repository
) {
    suspend operator fun invoke(vacation: Vacation) = repository.insertVacation(vacation)
}