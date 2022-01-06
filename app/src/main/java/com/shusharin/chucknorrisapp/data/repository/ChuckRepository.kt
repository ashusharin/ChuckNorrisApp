package com.shusharin.chucknorrisapp.data.repository

import com.shusharin.chucknorrisapp.data.ChuckData
import com.shusharin.chucknorrisapp.data.dataSource.remote.ChuckRemoteDataSource
import java.lang.Exception

interface ChuckRepository {

    suspend fun fetchJoke(): ChuckData

    class ChuckRepositoryImpl(private val remoteDataSource: ChuckRemoteDataSource) : ChuckRepository {
        override suspend fun fetchJoke() = try {
            ChuckData.Success(remoteDataSource.fetchJoke())
        } catch (e: Exception) {
            ChuckData.Fail(e)
        }
    }
}
