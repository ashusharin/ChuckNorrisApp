package com.shusharin.chucknorrisapp.domain

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.presentation.ChucksUI

interface ChucksDomainToUIMapper : Abstract.Mapper {

    fun map(joke: Chuck) : ChucksUI

    fun map(errorType: ErrorType) : ChucksUI
}