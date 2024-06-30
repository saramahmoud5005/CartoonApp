package com.example.domain.model

import androidx.compose.ui.graphics.Color


sealed class CharacterStatus(val status:String, color: Color) {
    object Alive:CharacterStatus("Alive",Color.Green)
    object Dead:CharacterStatus("Dead",Color.Red)
    object Unknown:CharacterStatus("Unknown",Color.Yellow)
}