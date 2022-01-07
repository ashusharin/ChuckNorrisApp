package com.shusharin.chucknorrisapp.data.dataSource.remote.api

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck

//Маппер для одной шутки
interface ChuckCloudMapper : Abstract.Mapper {

    fun map(icon: String, id: String, url: String, value: String): Chuck

    class ChuckCloudMapperImpl : ChuckCloudMapper {
        override fun map(icon: String, id: String, url: String, value: String) =
            Chuck(icon, id, url, value)
    }

}