package com.shusharin.chucknorrisapp.domain

import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.data.ChucksDataToDomainMapper

class ChucksDataToDomainMapperImpl : ChucksDataToDomainMapper {
    override fun map(jokes: List<Chuck>): ChucksDomain = ChucksDomain.Success(jokes)

    override fun map(e: Exception): ChucksDomain = ChucksDomain.Fail(e)

}