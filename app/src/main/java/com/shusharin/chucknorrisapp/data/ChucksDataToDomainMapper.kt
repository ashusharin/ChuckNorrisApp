package com.shusharin.chucknorrisapp.data

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.domain.ChuckDomain
/*
Dont push class
 */
interface ChucksDataToDomainMapper : Abstract.Mapper {

    fun map(joke: Chuck): ChuckDomain

    fun map(e: Exception): ChuckDomain


}