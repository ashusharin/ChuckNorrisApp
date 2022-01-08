package com.shusharin.chucknorrisapp.presentation

import android.app.VoiceInteractor
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.domain.ChucksDomainToUIMapper
import com.shusharin.chucknorrisapp.domain.ChucksInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val chuckInteractor: ChucksInteractor,
    private val chucksDomainToUIMapper: ChucksDomainToUIMapper,
    private val communication: ChuckCommunication
) : ViewModel() {

    fun fetchJoke() = viewModelScope.launch(Dispatchers.IO) {
        val result = chuckInteractor.fetchJoke().map(chucksDomainToUIMapper)
        with(Dispatchers.Main) {
            result.map(Abstract.Mapper.Empty())
        }
    }

    fun observe(owner:LifecycleOwner, observer: Observer<Chuck>) {
        communication.observeSuccess(owner, observer)
    }

}