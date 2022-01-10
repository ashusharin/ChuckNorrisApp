package com.shusharin.chucknorrisapp.domain

import com.shusharin.chucknorrisapp.data.ChucksDataToDomainMapper
import com.shusharin.chucknorrisapp.data.repository.ChuckRepository

interface ChucksInteractor {

    suspend fun fetchJoke(): ChucksDomain

    class ChucksInteractorImpl(
        private val chuckRepository: ChuckRepository,
        private val mapper: ChucksDataToDomainMapper,
    ) : ChucksInteractor {
        override suspend fun fetchJoke(): ChucksDomain = chuckRepository.fetchJoke().map(mapper)
    }
}
