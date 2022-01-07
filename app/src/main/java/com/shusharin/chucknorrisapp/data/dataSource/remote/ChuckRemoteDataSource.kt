package com.shusharin.chucknorrisapp.data.dataSource.remote

import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckCloud
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckService

interface ChuckRemoteDataSource {

    suspend fun fetchJoke() : ChuckCloud

    class RemoteDataSourceImpl(private val service : ChuckService) : ChuckRemoteDataSource {
        override suspend fun fetchJoke(): ChuckCloud {
            return service.fetchJoke()
        }

    }
}