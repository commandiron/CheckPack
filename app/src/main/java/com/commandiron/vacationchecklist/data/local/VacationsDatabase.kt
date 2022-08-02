package com.commandiron.vacationchecklist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.commandiron.vacationchecklist.data.local.entity.VacationEntity

@Database(
    entities = [VacationEntity::class],
    version = 1,
    exportSchema = false
)
abstract class VacationsDatabase: RoomDatabase(){
    abstract val dao: VacationsDao
}