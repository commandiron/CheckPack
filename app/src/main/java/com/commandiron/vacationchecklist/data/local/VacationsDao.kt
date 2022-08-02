package com.commandiron.vacationchecklist.data.local

import androidx.room.*
import com.commandiron.vacationchecklist.data.local.entity.VacationEntity

@Dao
interface VacationsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVacation(vacationEntity: VacationEntity)

    @Query("SELECT * FROM vacationentity WHERE id=:id")
    suspend fun getVacation(id:Int): VacationEntity?
}