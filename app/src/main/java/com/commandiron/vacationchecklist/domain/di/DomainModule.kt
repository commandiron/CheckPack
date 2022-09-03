package com.commandiron.vacationchecklist.domain.di

import com.commandiron.vacationchecklist.domain.repository.Repository
import com.commandiron.vacationchecklist.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @ViewModelScoped
    @Provides
    fun provideUseCases(
        repository: Repository
    ): UseCases {
        return UseCases(
            getAllVacations = GetAllVacations(),
            insertAllChecklistItems = InsertAllChecklistItems(repository),
            getChecklistItems = GetChecklistItems(repository),
            insertChecklistItem = InsertChecklistItem(repository)
        )
    }
}