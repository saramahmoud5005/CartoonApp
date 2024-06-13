package com.example.data.remote

import com.example.domain.model.CharacterResponse
import com.example.domain.model.EpisodesResponse
import com.example.domain.model.login.LoginRequest
import com.example.domain.model.login.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST
    fun login(@Body request: LoginRequest): Call<LoginResponse>
//    @FromUrlEncoded

    @GET(Constants.CHARACTER_URL)
    suspend fun getCharacters(): CharacterResponse

    @GET(Constants.EPISODE_URL)
    suspend fun getEpisodes():EpisodesResponse
}