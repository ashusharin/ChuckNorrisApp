package com.shusharin.chucknorrisapp.data.repository

import com.shusharin.chucknorrisapp.data.ChucksData
import com.shusharin.chucknorrisapp.data.dataSource.local.ChuckLocalDataSource
import com.shusharin.chucknorrisapp.data.dataSource.local.mapper.ChucksLocalMapper
import com.shusharin.chucknorrisapp.data.dataSource.remote.ChuckRemoteDataSource
import com.shusharin.chucknorrisapp.data.repository.mapper.ChucksCloudMapper

interface ChuckRepository {

    suspend fun fetchJoke(): ChucksData

    class ChuckRepositoryImpl(
        private val remoteDataSource: ChuckRemoteDataSource,
        private val localDataSource: ChuckLocalDataSource,
        private val chucksCloudMapper: ChucksCloudMapper,
        private val chucksLocalMapper: ChucksLocalMapper,
    ) : ChuckRepository {
        override suspend fun fetchJoke() = try {
            val jokeLocal = localDataSource.fetchJoke()
            if (jokeLocal.isEmpty()) {
                val jokeCloud = remoteDataSource.fetchJoke()
                val joke = chucksCloudMapper.map(jokeCloud)
                localDataSource.saveJoke(joke)
                ChucksData.Success(joke)
            } else {
                ChucksData.Success(chucksLocalMapper.map(jokeLocal))
            }
            //Get data from remote
            //Map this data to our model

        } catch (e: Exception) {
            ChucksData.Fail(e)
        }
    }
}
