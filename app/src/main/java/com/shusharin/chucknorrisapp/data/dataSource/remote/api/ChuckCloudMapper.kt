package com.shusharin.chucknorrisapp.data.dataSource.remote.api

import com.google.gson.annotations.SerializedName
import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck

//Маппер для одной шутки
interface ChuckCloudMapper : Abstract.Mapper {

    fun map(
        categories: List<String>,
        createdAt: String,
        icon: String,
        id: String,
        updatedAt: String,
        url: String,
        value: String,
    ): Chuck

    class ChuckCloudMapperImpl : ChuckCloudMapper {
        override fun map(
            categories: List<String>,
            createdAt: String,
            icon: String,
            id: String,
            updatedAt: String,
            url: String,
            value: String,
        ) =
            Chuck(categories,createdAt,icon, id,updatedAt, url, value)
    }
}