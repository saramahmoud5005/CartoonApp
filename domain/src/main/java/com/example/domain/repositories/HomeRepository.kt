package com.example.domain.repositories

import com.example.domain.model.CharacterResponse
import com.example.domain.model.EpisodesResponse

interface HomeRepository {
    suspend fun getCharacters():CharacterResponse
    suspend fun getEpisodes():EpisodesResponse
}