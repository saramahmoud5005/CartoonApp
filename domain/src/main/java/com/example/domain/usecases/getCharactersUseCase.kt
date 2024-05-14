package com.example.domain.usecases

import com.example.domain.model.CharacterResponse
import com.example.domain.repositories.HomeRepository

class getCharactersUseCase(
    private val homeRepository: HomeRepository
){
    suspend operator fun invoke() = homeRepository.getCharacters()
}