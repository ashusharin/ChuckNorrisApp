package com.shusharin.chucknorrisapp.data

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.domain.ChucksDomain

/*
Dont push class
 */
interface ChucksDataToDomainMapper : Abstract.Mapper {

    fun map(joke: List<Chuck>): ChucksDomain

    fun map(e: Exception): ChucksDomain


}