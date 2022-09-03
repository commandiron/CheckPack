package com.commandiron.vacationchecklist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.commandiron.vacationchecklist.data.local.entity.CheckItemEntity

@Database(
    entities = [CheckItemEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ChecklistDatabase: RoomDatabase(){
    abstract val dao: ChecklistDao
}