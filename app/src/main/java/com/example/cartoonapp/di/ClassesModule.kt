package com.example.cartoonapp.di

import com.example.data.remote.ApiService
import com.example.data.repo.HomeRepositoryImpl
import com.example.domain.repositories.HomeRepository
import com.example.domain.usecases.getCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ClassesModule {

    @Provides
    fun provideGetCharacterUseCase(apiService: ApiService):HomeRepository{
        return HomeRepositoryImpl(apiService)
    }
    @Provides
    fun provideHomeRepository(homeRepository: HomeRepository):getCharactersUseCase{
        return getCharactersUseCase(homeRepository)
    }
}