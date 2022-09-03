package com.commandiron.vacationchecklist.data.di

import android.content.Context
import androidx.room.Room
import com.commandiron.vacationchecklist.data.local.ChecklistItemDao
import com.commandiron.vacationchecklist.data.local.ChecklistItemDatabase
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
    fun provideChecklistItemDatabase(
        @ApplicationContext context: Context,
    ): ChecklistItemDatabase {
        return Room.databaseBuilder(
            context,
            ChecklistItemDatabase::class.java,
            "checklistItem_db"
        ).build()
    }

    @Provides
    fun provideChecklistItemDao(database: ChecklistItemDatabase) = database.dao

    @Provides
    @Singleton
    fun provideToolsRepository(
        checklistItemDao: ChecklistItemDao
    ): Repository {
        return DefaultRepositoryImpl(
            dao = checklistItemDao
        )
    }
}