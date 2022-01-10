package com.shusharin.chucknorrisapp.presentation

import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.domain.ChucksDomainToUIMapper
import com.shusharin.chucknorrisapp.domain.ErrorType

class ChucksDomainToUIMapperImpl(
    private val communication: ChuckCommunication,
    private val resourceProvider: ResourceProvider,
) : ChucksDomainToUIMapper {
    override fun map(joke: List<Chuck>): ChucksUI = ChucksUI.Success(joke, communication)

    override fun map(errorType: ErrorType): ChucksUI =
        ChucksUI.Fail(errorType, communication, resourceProvider)
}