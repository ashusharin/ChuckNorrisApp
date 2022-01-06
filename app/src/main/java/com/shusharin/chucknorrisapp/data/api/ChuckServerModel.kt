package com.shusharin.chucknorrisapp.data.api

import com.google.gson.annotations.SerializedName
import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.data.ChuckData

// TODO: 06.01.2022 fix
/**
"icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png"
"id":"Jim0jIOySUmV7Bbz5TFyXQ"
"url":"http://api.chucknorris.io/jokes/Jim0jIOySUmV7Bbz5TFyXQ"
"value":"Chuck Norris cornrows his crotch hair."
}
**/
data class ChuckServerModel(
    @SerializedName("icon_url")
    private val icon:String,
    @SerializedName("id")
    private val id:String,
    @SerializedName("url")
    private val url:String,
    @SerializedName("value")
    private val value:String
) : Abstract.Object<ChuckData, ChuckServerModelToData>(){
    override fun map(mapper: ChuckServerModelToData): ChuckData {
        return mapper.map(icon,id,url,value)
    }

}
