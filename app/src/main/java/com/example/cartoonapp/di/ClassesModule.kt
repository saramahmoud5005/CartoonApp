package com.example.cartoonapp.di

import com.example.data.remote.ApiService
import com.example.data.repo.HomeRepositoryImpl
import com.example.domain.repositories.HomeRepository
import com.example.domain.usecases.GetCharactersUseCase
import com.example.domain.usecases.GetEpisodesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ClassesModule {

    @Provides
    fun provideHomeRepository(apiService: ApiService):HomeRepository{
        return HomeRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetEpisodesUseCase(homeRepository: HomeRepository):GetEpisodesUseCase{
        return GetEpisodesUseCase(homeRepository)
    }
    @Provides
    fun  provideGetCharacterUseCase(homeRepository: HomeRepository):GetCharactersUseCase{
        return GetCharactersUseCase(homeRepository)
    }
}