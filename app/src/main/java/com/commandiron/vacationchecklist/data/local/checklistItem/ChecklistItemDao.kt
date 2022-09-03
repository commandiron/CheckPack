package com.commandiron.vacationchecklist.data.local.checklistItem

import androidx.room.*
import com.commandiron.vacationchecklist.data.local.entity.ChecklistItemEntity
import com.commandiron.vacationchecklist.domain.model.ChecklistItem

@Dao
interface ChecklistItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChecklistItems(vararg checklistItemEntity: ChecklistItemEntity)

    @Query("SELECT * FROM checklistitementity")
    suspend fun getAllChecklistItems(): List<ChecklistItemEntity>
}