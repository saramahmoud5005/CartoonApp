package com.example.cartoonapp

import com.example.domain.model.Result

data class HomeState(
    val isLoading: Boolean,
    val result: List<Result>,
    val error : String
)