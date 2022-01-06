package com.shusharin.chucknorrisapp.data.dataSource.remote

import com.shusharin.chucknorrisapp.data.api.ChuckServerModel
import com.shusharin.chucknorrisapp.data.api.ChuckService

interface ChuckRemoteDataSource {

    suspend fun fetchJoke() : ChuckServerModel

    class RemoteDataSourceImpl(private val service : ChuckService) : ChuckRemoteDataSource {
        override suspend fun fetchJoke(): ChuckServerModel {
            return service.fetchJoke()
        }

    }
}