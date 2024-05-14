package com.example.domain.repositories

import com.example.domain.model.CharacterResponse

interface HomeRepository {
    suspend fun getCharacters():CharacterResponse
}