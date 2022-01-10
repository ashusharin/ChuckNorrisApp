package com.shusharin.chucknorrisapp.data.dataSource.remote

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckCloud
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckService

interface ChuckRemoteDataSource {

    suspend fun fetchJoke(): List<ChuckCloud>

    class RemoteDataSourceImpl(private val service: ChuckService) : ChuckRemoteDataSource {
        //Решение проблемы получения от сервера данных в виде массива, а не gson
//        private val gson = Gson()
//        private val type = object : TypeToken<List<ChuckCloud>>() {}.type

        // TODO: 10.01.2022 подумать как исправить: получение данных с сервера 
        override suspend fun fetchJoke(): List<ChuckCloud> {
            var list = mutableListOf<ChuckCloud>()
            val item = service.fetchJoke()
            list.add(item)
            return list.toList()
        }

    }
}