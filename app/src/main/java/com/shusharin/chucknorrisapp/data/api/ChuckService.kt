package com.shusharin.chucknorrisapp.data.api

import retrofit2.http.GET

interface ChuckService {

    @GET("/random")
    suspend fun fetchJoke():ChuckServerModel
}