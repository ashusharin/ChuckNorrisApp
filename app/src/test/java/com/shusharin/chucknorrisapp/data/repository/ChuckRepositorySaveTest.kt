package com.shusharin.chucknorrisapp.data.repository

import com.shusharin.chucknorrisapp.core.Chuck
import com.shusharin.chucknorrisapp.data.ChucksData
import com.shusharin.chucknorrisapp.data.dataSource.local.ChuckDB
import com.shusharin.chucknorrisapp.data.dataSource.local.ChuckLocalDataSource
import com.shusharin.chucknorrisapp.data.dataSource.local.mapper.ChuckLocalMapper
import com.shusharin.chucknorrisapp.data.dataSource.local.mapper.ChucksLocalMapper
import com.shusharin.chucknorrisapp.data.dataSource.remote.ChuckRemoteDataSource
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckCloud
import com.shusharin.chucknorrisapp.data.dataSource.remote.api.ChuckCloudMapper
import com.shusharin.chucknorrisapp.data.repository.mapper.ChucksCloudMapper
import io.realm.RealmList
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ChuckRepositorySaveTest : BaseChucksRepositoryTest() {

    @Test
    fun test_save_joke() = runBlocking {
        val testRemoteDataSource = TestChuksCloudDataSource()
        val testLocalDataSource = TestChuksLocalDataSource()
        val repository = ChuckRepository.ChuckRepositoryImpl(
            testRemoteDataSource,
            testLocalDataSource,
            ChucksCloudMapper.ChucksCloudMapperImpl(TestChuckCloudMapper()),
            ChucksLocalMapper.ChucksLocalMapperImpl(TestChuckLocalMapper())
        )
        val actualCloud = repository.fetchJoke()
        val expectedCloud = ChucksData.Success(listOf(
            Chuck(RealmList<String>(), "11.222", "lkjji", "222", "2222", "asd", "asdasd"),
            Chuck(RealmList<String>(), "11.222", "lkjji", "222", "2222", "asd", "asdasd"),
        ))
        assertEquals(expectedCloud, actualCloud)

        val actualCache = repository.fetchJoke()
        val expectedCache = ChucksData.Success(listOf(
            Chuck(RealmList<String>(), "11.222", "lkjji", "222", "2222", "asd", "asdasd db"),
            Chuck(RealmList<String>(), "11.222", "lkjji", "222", "2222", "asd", "asdasd db"),
        ))
        assertEquals(expectedCache, actualCache)

    }

    private inner class TestChuksCloudDataSource() :
        ChuckRemoteDataSource {
        override suspend fun fetchJoke(): List<ChuckCloud> {
            return listOf(
                ChuckCloud(RealmList<String>(), "11.222", "lkjji", "222", "2222", "asd", "asdasd"),
                ChuckCloud(RealmList<String>(), "11.222", "lkjji", "222", "2222", "asd", "asdasd"),
            )
        }
    }


    private inner class TestChuksLocalDataSource() : ChuckLocalDataSource {

        private val list = ArrayList<ChuckDB>()
        override fun fetchJoke(): List<ChuckDB> = list


        override fun saveJoke(jokes: List<Chuck>) {
            jokes.map { joke ->
                list.add(ChuckDB().apply {
                    id = joke.id
                    value = "${joke.value} db"
                    categories = RealmList<String>()
                    createdAt = joke.createdAt
                    icon = joke.icon
                    updatedAt = joke.updatedAt
                    url = joke.url
                })
            }
        }
    }


}