package com.commandiron.vacationchecklist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.commandiron.vacationchecklist.data.local.entity.ChecklistItemEntity

@Database(
    entities = [ChecklistItemEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ChecklistItemDatabase: RoomDatabase(){
    abstract val dao: ChecklistItemDao
}