package com.shusharin.chucknorrisapp.presentation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.shusharin.chucknorrisapp.core.Chuck

interface ChuckCommunication {

    fun show(joke: Chuck)
    fun show(errorMessage: String)

    fun observeSuccess(owner: LifecycleOwner,observer: Observer<Chuck>)
    fun observeFail(owner: LifecycleOwner,observer: Observer<String>)

    class ChuckCommunicationImpl : ChuckCommunication {
        private val successLiveData = MutableLiveData<Chuck>()
        private val failLiveData = MutableLiveData<String>()
        override fun show(joke: Chuck) {
            successLiveData.value = joke
        }

        override fun show(errorMessage: String) {
            failLiveData.value = errorMessage
        }

        override fun observeSuccess(owner: LifecycleOwner, observer: Observer<Chuck>) {
            successLiveData.observe(owner, observer)
        }

        override fun observeFail(owner: LifecycleOwner, observer: Observer<String>) {
            failLiveData.observe(owner, observer)
        }
    }
}