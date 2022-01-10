package com.shusharin.chucknorrisapp.data.dataSource.remote.api.mapper

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.domain.ChucksDomain

interface ChuckDataToDomainMapper : Abstract.Mapper {

    fun map(joke: Chuck): ChucksDomain

    fun map(e: Exception): ChucksDomain


}