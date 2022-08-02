package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.domain.model.Vacation
import com.commandiron.vacationchecklist.domain.repository.Repository
import com.commandiron.vacationchecklist.util.Response
import kotlinx.coroutines.flow.Flow

class GetVacation(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int): Flow<Response<Vacation>> = repository.getVacation(id)
}