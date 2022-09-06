package com.commandiron.vacationchecklist.domain.di

import android.content.Context
import com.commandiron.vacationchecklist.domain.repository.Repository
import com.commandiron.vacationchecklist.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @ViewModelScoped
    @Provides
    fun provideUseCases(
        @ApplicationContext context: Context,
        repository: Repository
    ): UseCases {
        return UseCases(
            getAllVacations = GetAllVacations(),
            insertAllCheckItems = InsertAllCheckItems(repository),
            deleteAllCheckItems = DeleteAllCheckItems(repository),
            getAllCheckItems = GetAllCheckItems(repository),
            insertCheckItem = InsertCheckItem(repository),
            setAlarm = SetAlarm(context)
        )
    }
}