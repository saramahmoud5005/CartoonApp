package com.example.cartoonapp

import com.example.domain.model.Result

data class State(
    val isLoading: Boolean,
    val result: List<Result>,
    val error : String
)