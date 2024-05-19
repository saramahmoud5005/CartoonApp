package com.example.domain.usecases

import com.example.domain.repositories.HomeRepository

class GetEpisodesUseCase(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke() = homeRepository.getEpisodes()
}