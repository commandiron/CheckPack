package com.commandiron.vacationchecklist.data.di

import android.content.Context
import androidx.room.Room
import com.commandiron.vacationchecklist.data.local.ChecklistDao
import com.commandiron.vacationchecklist.data.local.ChecklistDatabase
import com.commandiron.vacationchecklist.data.repository.DefaultRepositoryImpl
import com.commandiron.vacationchecklist.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideChecklistDatabase(
        @ApplicationContext context: Context,
    ): ChecklistDatabase {
        return Room.databaseBuilder(
            context,
            ChecklistDatabase::class.java,
            "checklist_db"
        ).build()
    }

    @Provides
    fun provideChecklistDao(database: ChecklistDatabase) = database.dao

    @Provides
    @Singleton
    fun provideToolsRepository(
        checklistDao: ChecklistDao
    ): Repository {
        return DefaultRepositoryImpl(
            dao = checklistDao
        )
    }
}