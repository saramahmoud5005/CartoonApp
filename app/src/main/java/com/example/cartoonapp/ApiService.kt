package com.example.cartoonapp

import com.example.cartoonapp.model.CharacterResponse
import retrofit2.http.GET

interface ApiService {

    @GET("characters")
    fun getCharacters(): CharacterResponse

}