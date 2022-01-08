package com.shusharin.chucknorrisapp.domain

import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.data.ChucksDataToDomainMapper

class ChucksDataToDomainMapperImpl : ChucksDataToDomainMapper {
    override fun map(joke: Chuck): ChuckDomain = ChuckDomain.Success(joke)

    override fun map(e: Exception): ChuckDomain = ChuckDomain.Fail(e)

}