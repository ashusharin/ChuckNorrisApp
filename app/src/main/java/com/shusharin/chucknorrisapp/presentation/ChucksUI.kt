package com.shusharin.chucknorrisapp.presentation

import com.shusharin.chucknorrisapp.R
import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.domain.ErrorType

sealed class ChucksUI : Abstract.Object<Unit, Abstract.Mapper.Empty>() {

    class Success(
        private val jokes: List<Chuck>,
        private val communication: ChuckCommunication,
    ) : ChucksUI() {
        override fun map(mapper: Abstract.Mapper.Empty) {
            communication.show(jokes)
        }
    }

    class Fail(
        private val errorType: ErrorType,
        private val communication: ChuckCommunication,
        private val  resourceProvider: ResourceProvider
    ) : ChucksUI() {
        override fun map(mapper: Abstract.Mapper.Empty) {
            val messageId = when(errorType){ //todo move to other class
                ErrorType.NO_CONNECTION -> R.string.no_connection_message
                ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable
                else -> R.string.something_went_wrong

            }
            communication.show(resourceProvider.getString(messageId))
        }
    }

}