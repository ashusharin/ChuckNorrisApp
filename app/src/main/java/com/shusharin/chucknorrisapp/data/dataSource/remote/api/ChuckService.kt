package com.shusharin.chucknorrisapp.data.dataSource.remote.api

import retrofit2.http.GET

interface ChuckService {

    @GET("/random")
    suspend fun fetchJoke():ChuckCloud
}