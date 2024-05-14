package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.model.CharacterResponse
import com.example.domain.repositories.HomeRepository

class HomeRepositoryImpl(
    private val apiService: ApiService
) : HomeRepository {
    override suspend fun getCharacters(): CharacterResponse = apiService.getCharacters()
}