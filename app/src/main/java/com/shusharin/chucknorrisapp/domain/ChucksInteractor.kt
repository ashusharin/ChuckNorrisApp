package com.shusharin.chucknorrisapp.domain

import com.shusharin.chucknorrisapp.data.ChuckRepository
import com.shusharin.chucknorrisapp.data.ChucksDataToDomainMapper
import com.shusharin.chucknorrisapp.presentation.ChucksUI

interface ChucksInteractor {

    suspend fun fetchJoke(): ChuckDomain

    class ChucksInteractorImpl(
        private val chuckRepository: ChuckRepository,
        private val mapper: ChucksDataToDomainMapper,
    ) : ChucksInteractor {
        override suspend fun fetchJoke(): ChuckDomain = chuckRepository.fetchJoke().map(mapper)
    }
}
