package com.shusharin.chucknorrisapp.data.dataSource.local

import com.shusharin.chucknorrisapp.core.Abstract
import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.data.dataSource.local.mapper.ChuckLocalMapper
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
"icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png"
"id":"Jim0jIOySUmV7Bbz5TFyXQ"
"url":"http://api.chucknorris.io/jokes/Jim0jIOySUmV7Bbz5TFyXQ"
"value":"Chuck Norris cornrows his crotch hair."
}
 **/

open class ChuckDB : RealmObject(), Abstract.Mapable<Chuck, ChuckLocalMapper> {
    var categories = RealmList<String>()
    var createdAt:String = ""
    var icon: String = ""
    @PrimaryKey
    var id: String = "-1"
    var updatedAt: String = ""
    var url: String = ""
    var value: String = ""

    override fun map(mapper: ChuckLocalMapper) = Chuck(categories,createdAt,icon, id,updatedAt, url, value)
}