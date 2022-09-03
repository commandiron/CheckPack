package com.commandiron.vacationchecklist.data.local

import androidx.room.*
import com.commandiron.vacationchecklist.data.local.entity.CheckItemEntity

@Dao
interface ChecklistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg checkItemEntity: CheckItemEntity)

    @Query("DELETE FROM checkitementity")
    suspend fun deleteAll()

    @Query("SELECT * FROM checkitementity")
    suspend fun getAll(): List<CheckItemEntity>
}