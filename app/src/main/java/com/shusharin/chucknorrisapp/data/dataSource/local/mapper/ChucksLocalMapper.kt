package com.shusharin.chucknorrisapp.data.dataSource.local.mapper

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.data.dataSource.local.ChuckDB

//Маппер для листа
interface ChucksLocalMapper : Abstract.Mapper {

    fun map(jokes: List<ChuckDB>) : List<Chuck>
    //для листа fun map(joke: List<ChuckDB>) : List<Chuck>

class ChucksLocalMapperImpl(private val mapper:ChuckLocalMapper):ChucksLocalMapper{
    // для листа list.map{ joke.map(mapper)}
    override fun map(jokes: List<ChuckDB>) = jokes.map{ it.map(mapper)}
}

}