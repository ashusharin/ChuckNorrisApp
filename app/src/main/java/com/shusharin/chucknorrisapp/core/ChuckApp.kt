package com.shusharin.chucknorrisapp.core

import android.app.Application
import com.shusharin.chucknorrisapp.data.ChuckRepository
import com.shusharin.chucknorrisapp.domain.ChucksDataToDomainMapperImpl
import com.shusharin.chucknorrisapp.domain.ChucksInteractor

class ChuckApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val chucksRepository : ChuckRepository = TODO("merge")
        val chuckInteractor = ChucksInteractor.ChucksInteractorImpl(chucksRepository, ChucksDataToDomainMapperImpl( ))
    }
}