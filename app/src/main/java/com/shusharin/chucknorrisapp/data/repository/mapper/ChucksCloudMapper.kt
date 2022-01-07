package com.shusharin.chucknorrisapp.data.repository.mapper

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckCloud
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckCloudMapper

//Если бы был список шуток, то этот класс мапил бы весь лист. В данной апке он не нужен
interface ChucksCloudMapper : Abstract.Mapper {

    fun map(cloudJoke: ChuckCloud): Chuck

    class ChucksCloudMapperImpl(private val chuckMapper: ChuckCloudMapper) :
        ChucksCloudMapper {
        override fun map(cloudJoke: ChuckCloud) = cloudJoke.map(chuckMapper)
        // если был list: list.map{ cloudJoke ->
        // cloudjoke.map(chuckMapper)}
        }
    }