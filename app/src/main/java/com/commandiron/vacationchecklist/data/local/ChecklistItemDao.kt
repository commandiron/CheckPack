package com.commandiron.vacationchecklist.data.local

import androidx.room.*
import com.commandiron.vacationchecklist.data.local.entity.ChecklistItemEntity
import com.commandiron.vacationchecklist.domain.model.ChecklistItem

@Dao
interface ChecklistItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg checklistItemEntity: ChecklistItemEntity)

    @Query("DELETE FROM checklistitementity")
    suspend fun deleteAll()

    @Query("SELECT * FROM checklistitementity")
    suspend fun getAll(): List<ChecklistItemEntity>
}