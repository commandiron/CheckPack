package com.commandiron.vacationchecklist.domain.di

import com.commandiron.vacationchecklist.domain.repository.Repository
import com.commandiron.vacationchecklist.domain.use_cases.CreateVacation
import com.commandiron.vacationchecklist.domain.use_cases.GetVacation
import com.commandiron.vacationchecklist.domain.use_cases.GetVacations
import com.commandiron.vacationchecklist.domain.use_cases.UseCases
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
            getVacations = GetVacations(),
            createVacation = CreateVacation(repository),
            getVacation = GetVacation(repository)
        )
    }
}