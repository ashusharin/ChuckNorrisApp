package com.shusharin.chucknorrisapp.core

import android.app.Application
import com.shusharin.chucknorrisapp.domain.ChucksDomainToUIMapper
import com.shusharin.chucknorrisapp.domain.ChucksInteractor
import com.shusharin.chucknorrisapp.presentation.ChuckCommunication
import com.shusharin.chucknorrisapp.presentation.ChucksDomainToUIMapperImpl
import com.shusharin.chucknorrisapp.presentation.MainViewModel
import com.shusharin.chucknorrisapp.presentation.ResourceProvider

class ChuckApp : Application() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate() {
        super.onCreate()

        val chucksInteractor: ChucksInteractor = TODO()
        mainViewModel = MainViewModel(chucksInteractor,
            ChucksDomainToUIMapperImpl(ChuckCommunication.ChuckCommunicationImpl(),
                ResourceProvider.ResourceProviderImpl(this)))
    }
}