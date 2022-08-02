package com.commandiron.vacationchecklist.data.repository

import com.commandiron.vacationchecklist.data.local.VacationsDao
import com.commandiron.vacationchecklist.data.mapper.toVacation
import com.commandiron.vacationchecklist.data.mapper.toVacationEntity
import com.commandiron.vacationchecklist.domain.model.Vacation
import com.commandiron.vacationchecklist.domain.repository.Repository
import com.commandiron.vacationchecklist.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DefaultRepositoryImpl(
    private val dao: VacationsDao,
): Repository {
    override suspend fun insertVacation(vacation: Vacation) {
        dao.insertVacation(vacation.toVacationEntity())
    }

    override suspend fun getVacation(id: Int): Flow<Response<Vacation>> = flow {
        emit(Response.Loading)
        val vacation = dao.getVacation(id)?.toVacation()
        if(vacation != null){
            emit(Response.Success(vacation))
        }else{
            emit(Response.Error("Null"))
        }
    }
}