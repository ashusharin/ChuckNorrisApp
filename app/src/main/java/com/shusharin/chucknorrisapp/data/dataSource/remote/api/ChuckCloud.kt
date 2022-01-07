package com.shusharin.chucknorrisapp.data.dataSource.remote.api

import com.google.gson.annotations.SerializedName
import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck

// TODO: 06.01.2022 fix
/**
"icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png"
"id":"Jim0jIOySUmV7Bbz5TFyXQ"
"url":"http://api.chucknorris.io/jokes/Jim0jIOySUmV7Bbz5TFyXQ"
"value":"Chuck Norris cornrows his crotch hair."
}
 **/
data class ChuckCloud(
    @SerializedName("icon_url")
    private val icon: String,
    @SerializedName("id")
    private val id: String,
    @SerializedName("url")
    private val url: String,
    @SerializedName("value")
    private val value: String,
) : Abstract.Object<Chuck, ChuckCloudMapper>() {
    override fun map(mapper: ChuckCloudMapper) = mapper.map(icon, id, url, value)
}


