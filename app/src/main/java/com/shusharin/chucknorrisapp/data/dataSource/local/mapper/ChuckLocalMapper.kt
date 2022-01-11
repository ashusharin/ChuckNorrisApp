package com.shusharin.chucknorrisapp.data.dataSource.local.mapper

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.data.dataSource.local.ChuckDB

interface ChuckLocalMapper : Abstract.Mapper {

    fun map(joke: ChuckDB): Chuck

    class ChuckLocalMapperImpl : ChuckLocalMapper {
        override fun map(joke: ChuckDB): Chuck {
            return Chuck(joke.categories,
                joke.createdAt,
                joke.icon,
                joke.id,
                joke.updatedAt,
                joke.url,
                joke.value)
        }
    }



}