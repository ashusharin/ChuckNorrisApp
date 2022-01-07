package com.shusharin.chucknorrisapp.core

import android.app.Application
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckCloudMapper
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckService
import com.shusharin.chucknorrisapp.data.dataSource.local.ChuckLocalDataSource
import com.shusharin.chucknorrisapp.data.dataSource.local.database.RealmProvider
import com.shusharin.chucknorrisapp.data.dataSource.local.mapper.ChuckLocalMapper
import com.shusharin.chucknorrisapp.data.dataSource.local.mapper.ChucksLocalMapper
import com.shusharin.chucknorrisapp.data.dataSource.remote.ChuckRemoteDataSource
import com.shusharin.chucknorrisapp.data.repository.ChuckRepository
import com.shusharin.chucknorrisapp.data.repository.mapper.ChucksCloudMapper
import retrofit2.Retrofit

class ChuckApp : Application() {

    private companion object {
        const val BASE_URL = "https://api.chucknorris.io/jokes"
    }

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        //todo add interceptor
        val service = retrofit.create(ChuckService::class.java)

        val remoteDataSource = ChuckRemoteDataSource.RemoteDataSourceImpl(service)
        val localDataSource = ChuckLocalDataSource.ChuckLocalDataSourceImpl(RealmProvider.Base())
        val chucksCloudMapper =
            ChucksCloudMapper.ChucksCloudMapperImpl(ChuckCloudMapper.ChuckCloudMapperImpl())
        val chucksLocalMapper =
            ChucksLocalMapper.ChucksLocalMapperImpl(ChuckLocalMapper.ChuckLocalMapperImpl())
        val chuckRepository = ChuckRepository.ChuckRepositoryImpl(
            remoteDataSource,
            localDataSource,
            chucksCloudMapper,
            chucksLocalMapper,
        )
    }
}