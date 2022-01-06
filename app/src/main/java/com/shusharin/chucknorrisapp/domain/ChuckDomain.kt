package com.shusharin.chucknorrisapp.domain

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.data.api.ChuckServerModel
import com.shusharin.chucknorrisapp.presentation.ChuckUi

sealed class ChuckDomain : Abstract.Object<ChuckUi, Abstract.Mapper.Empty>() {

    class Success() : ChuckDomain(){
        override fun map(mapper: Abstract.Mapper.Empty): ChuckUi {
            TODO("Not yet implemented")
        }

    }

    class Fail() : ChuckDomain(){
        override fun map(mapper: Abstract.Mapper.Empty): ChuckUi {
            TODO("Not yet implemented")
        }
    }

}
