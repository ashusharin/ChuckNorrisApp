package com.shusharin.chucknorrisapp.data

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.data.api.ChuckServerModel
import com.shusharin.chucknorrisapp.data.api.mapper.ChuckDataToDomainMapper
import com.shusharin.chucknorrisapp.domain.ChuckDomain
import java.lang.Exception


sealed class ChuckData : Abstract.Object<ChuckDomain, ChuckDataToDomainMapper>() {
    class Success(private val joke: ChuckServerModel) : ChuckData() {
        override fun map(mapper: ChuckDataToDomainMapper): ChuckDomain {
            return mapper.map(joke)
        }
    }

    class Fail(private val e:Exception) : ChuckData() {
        override fun map(mapper: ChuckDataToDomainMapper): ChuckDomain {
           return mapper.map(e)
        }
    }

}