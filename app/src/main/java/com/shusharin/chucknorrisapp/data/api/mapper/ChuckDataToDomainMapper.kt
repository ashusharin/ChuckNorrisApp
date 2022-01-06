package com.shusharin.chucknorrisapp.data.api.mapper

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.data.api.ChuckServerModel
import com.shusharin.chucknorrisapp.domain.ChuckDomain
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.net.UnknownHostException

interface ChuckDataToDomainMapper : Abstract.Mapper {

    fun map(joke: ChuckServerModel): ChuckDomain

    fun map(e: Exception): ChuckDomain

    class ChuckDataToDomainMapperImpl : ChuckDataToDomainMapper {
        override fun map(joke: ChuckServerModel): ChuckDomain {
            //todo аргументы
            return ChuckDomain.Success()
        }

        override fun map(e: Exception): ChuckDomain {
            val errorType = when (e) {
                is UnknownHostException -> 0 // enum noconnetion
                is HttpException -> 1 // ServiceUnavaliable
                else -> 2 // GenericException
            }
            return ChuckDomain.Fail()
        }

    }
}