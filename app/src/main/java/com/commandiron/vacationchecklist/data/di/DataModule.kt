package com.commandiron.vacationchecklist.data.di

import android.content.Context
import androidx.room.Room
import com.commandiron.vacationchecklist.data.local.VacationsCallback
import com.commandiron.vacationchecklist.data.local.VacationsDao
import com.commandiron.vacationchecklist.data.local.VacationsDatabase
import com.commandiron.vacationchecklist.data.repository.DefaultRepositoryImpl
import com.commandiron.vacationchecklist.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideVacationsDatabase(
        @ApplicationContext context: Context,
        provider: Provider<VacationsDao>
    ): VacationsDatabase {
        return Room.databaseBuilder(
            context,
            VacationsDatabase::class.java,
            "vacations_db"
        )
            .addCallback(VacationsCallback(provider))
            .build()
    }

    @Provides
    fun provideDao(database: VacationsDatabase) = database.dao

    @Provides
    @Singleton
    fun provideToolsRepository(
        dao: VacationsDao,
    ): Repository {
        return DefaultRepositoryImpl(
            dao = dao
        )
    }
}