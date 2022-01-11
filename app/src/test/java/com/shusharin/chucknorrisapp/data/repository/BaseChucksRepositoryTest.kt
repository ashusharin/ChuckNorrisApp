package com.shusharin.chucknorrisapp.data.repository

import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.data.dataSource.local.ChuckDB
import com.shusharin.chucknorrisapp.data.dataSource.local.mapper.ChuckLocalMapper
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckCloudMapper

abstract class BaseChucksRepositoryTest {

    protected inner class TestChuckCloudMapper : ChuckCloudMapper {
        override fun map(
            categories: List<String>,
            createdAt: String,
            icon: String,
            id: String,
            updatedAt: String,
            url: String,
            value: String,
        ) =
            Chuck(categories, createdAt, icon, id, updatedAt, url, value)
    }

    protected inner class TestChuckLocalMapper : ChuckLocalMapper {
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