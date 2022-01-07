package com.shusharin.chucknorrisapp.data.dataSource.remote.api.mapper

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.domain.ChuckDomain

interface ChuckDataToDomainMapper : Abstract.Mapper {

    fun map(joke: Chuck): ChuckDomain

    fun map(e: Exception): ChuckDomain


}