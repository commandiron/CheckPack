package com.commandiron.vacationchecklist.domain.repository

import com.commandiron.vacationchecklist.domain.model.Vacation
import com.commandiron.vacationchecklist.util.Response
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun insertVacation(vacation: Vacation)
    suspend fun getVacation(id: Int): Flow<Response<Vacation>>
}