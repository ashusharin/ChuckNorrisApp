package com.shusharin.chucknorrisapp.data

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.mapper.ChuckDataToDomainMapper
import com.shusharin.chucknorrisapp.domain.ChuckDomain


sealed class ChuckData : Abstract.Object<ChuckDomain, ChuckDataToDomainMapper>() {
    class Success(private val joke: Chuck) : ChuckData() {
        override fun map(mapper: ChuckDataToDomainMapper) = mapper.map(joke)
    }

    class Fail(private val e: Exception) : ChuckData() {
        override fun map(mapper: ChuckDataToDomainMapper) = mapper.map(e)
    }


}


