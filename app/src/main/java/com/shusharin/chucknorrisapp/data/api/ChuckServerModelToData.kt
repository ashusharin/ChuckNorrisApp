package com.shusharin.chucknorrisapp.data.api

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.data.ChuckData

interface ChuckServerModelToData : Abstract.Mapper {

    fun map(icon: String, id: String, url: String, value: String) :ChuckData

}