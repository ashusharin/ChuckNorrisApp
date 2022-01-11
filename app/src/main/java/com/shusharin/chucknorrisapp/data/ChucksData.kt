package com.shusharin.chucknorrisapp.data

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.mapper.ChuckDataToDomainMapper
import com.shusharin.chucknorrisapp.domain.ChucksDomain


sealed class ChucksData : Abstract.Object<ChucksDomain, ChucksDataToDomainMapper>() {
    data class Success(private val joke: List<Chuck>) : ChucksData() {
        override fun map(mapper: ChucksDataToDomainMapper) = mapper.map(joke)
    }

    data class Fail(private val e: Exception) : ChucksData() {
        override fun map(mapper: ChucksDataToDomainMapper) = mapper.map(e)
    }


}