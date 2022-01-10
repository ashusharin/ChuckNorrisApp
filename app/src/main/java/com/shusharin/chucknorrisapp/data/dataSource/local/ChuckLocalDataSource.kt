package com.shusharin.chucknorrisapp.data.dataSource.local

import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.data.dataSource.local.database.RealmProvider

interface ChuckLocalDataSource {

    fun fetchJoke(): List<ChuckDB>

    // Передаем одну шутку
    fun saveJoke(jokes: List<Chuck>)

    class ChuckLocalDataSourceImpl(private val realmProvider: RealmProvider) :
        ChuckLocalDataSource {
        override fun fetchJoke(): List<ChuckDB> {
            realmProvider.provide().use { realm ->
                val joke = realm.where(ChuckDB::class.java).findAll() ?: emptyList()
                return realm.copyFromRealm(joke)
            }
        }

        override fun saveJoke(jokes: List<Chuck>) =
            realmProvider.provide().use { realm ->
                realm.executeTransaction {
                    //Если передаем лист, то добавляем итерацию
                    jokes.forEach { joke ->
                        val jokeDb = it.createObject(ChuckDB::class.java, joke.id)
                        jokeDb.icon = joke.icon
                        jokeDb.url = joke.url
                        jokeDb.value = joke.value
                    }
                }
            }
    }
}