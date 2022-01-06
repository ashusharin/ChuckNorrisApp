package com.shusharin.chucknorrisapp.core

import android.app.Application
import com.shusharin.chucknorrisapp.data.api.ChuckService
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

    }
}