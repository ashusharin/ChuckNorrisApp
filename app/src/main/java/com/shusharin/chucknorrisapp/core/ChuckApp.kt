package com.shusharin.chucknorrisapp.core

import android.app.Application
import com.shusharin.chucknorrisapp.data.repository.ChuckRepository
import com.shusharin.chucknorrisapp.domain.ChucksDataToDomainMapperImpl
import com.shusharin.chucknorrisapp.domain.ChucksInteractor
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckCloudMapper
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckService
import com.shusharin.chucknorrisapp.data.dataSource.local.ChuckLocalDataSource
import com.shusharin.chucknorrisapp.data.dataSource.local.database.RealmProvider
import com.shusharin.chucknorrisapp.data.dataSource.local.mapper.ChuckLocalMapper
import com.shusharin.chucknorrisapp.data.dataSource.local.mapper.ChucksLocalMapper
import com.shusharin.chucknorrisapp.data.dataSource.remote.ChuckRemoteDataSource
import com.shusharin.chucknorrisapp.data.repository.mapper.ChucksCloudMapper
import retrofit2.Retrofit
import com.shusharin.chucknorrisapp.presentation.ChuckCommunication
import com.shusharin.chucknorrisapp.presentation.ChucksDomainToUIMapperImpl
import com.shusharin.chucknorrisapp.presentation.MainViewModel
import com.shusharin.chucknorrisapp.presentation.ResourceProvider
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory

class ChuckApp : Application() {

    private companion object {
        const val BASE_URL = "https://api.chucknorris.io/jokes/"
    }

    lateinit var mainViewModel: MainViewModel
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val logger = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val okhttp = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

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
        val chuckInteractor =
            ChucksInteractor.ChucksInteractorImpl(chuckRepository, ChucksDataToDomainMapperImpl())
        val communication = ChuckCommunication.ChuckCommunicationImpl()
        mainViewModel = MainViewModel(chuckInteractor,
            ChucksDomainToUIMapperImpl(communication,
                ResourceProvider.ResourceProviderImpl(this)), communication)
    }
}