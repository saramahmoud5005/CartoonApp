package com.example.cartoonapp

import com.example.domain.model.Episode
import com.example.domain.model.Result

data class CharacterDetailsState(
    val isLoading: Boolean,
    val episodes: List<Episode>,
    val error : String
)
