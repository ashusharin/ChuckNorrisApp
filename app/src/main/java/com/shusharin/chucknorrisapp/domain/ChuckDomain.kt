package com.shusharin.chucknorrisapp.domain

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.presentation.ChucksUI
import retrofit2.HttpException
import java.net.UnknownHostException

sealed class ChuckDomain : Abstract.Object<ChucksUI, ChucksDomainToUIMapper>() {

    class Success(private val joke: Chuck) : ChuckDomain() {
        override fun map(mapper: ChucksDomainToUIMapper): ChucksUI = mapper.map(joke)
    }

    class Fail(private val e: Exception) : ChuckDomain() {
        override fun map(mapper: ChucksDomainToUIMapper): ChucksUI = mapper.map(
            when (e) {
                is UnknownHostException -> ErrorType.NO_CONNECTION
                is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                else -> ErrorType.GENERIC_ERROR
            })
    }
}



