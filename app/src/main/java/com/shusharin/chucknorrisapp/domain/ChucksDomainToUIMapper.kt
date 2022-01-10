package com.shusharin.chucknorrisapp.domain

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.presentation.ChuckCommunication
import com.shusharin.chucknorrisapp.presentation.ChucksUI
import com.shusharin.chucknorrisapp.presentation.ResourceProvider

interface ChucksDomainToUIMapper : Abstract.Mapper {

    fun map(joke: List<Chuck>): ChucksUI

    fun map(errorType: ErrorType): ChucksUI
}

