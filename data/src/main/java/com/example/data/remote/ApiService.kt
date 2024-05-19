package com.example.data.remote

import com.example.domain.model.CharacterResponse
import com.example.domain.model.EpisodesResponse
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): CharacterResponse

    @GET("episode")
    suspend fun getEpisodes():EpisodesResponse
}