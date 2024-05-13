package com.example.cartoonapp

import com.example.cartoonapp.model.CharacterResponse
import com.example.cartoonapp.model.Result

sealed class State {
    object Loading: State()
    data class Success(val result: List<Result>): State()
}