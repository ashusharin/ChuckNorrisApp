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
import io.realm.annotations.PrimaryKey
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.io.IOException
import java.net.UnknownHostException

class ChuckRepositoryTest : BaseChucksRepositoryTest() {
    val unknownHostException = UnknownHostException()

    @Test
    fun test_no_connection_no_cache() = runBlocking {
        val testRemoteDataSource = TestChuksCloudDataSource(returnSuccess = false)
        val testLocalDataSource = TestChuksLocalDataSource(returnSuccess = false)
        val repository = ChuckRepository.ChuckRepositoryImpl(
            testRemoteDataSource,
            testLocalDataSource,
            ChucksCloudMapper.ChucksCloudMapperImpl(TestChuckCloudMapper()),
            ChucksLocalMapper.ChucksLocalMapperImpl(TestChuckLocalMapper())
        )
        val actual = repository.fetchJoke()
        val expected = ChucksData.Fail(unknownHostException)
        assertEquals(expected, actual)
    }

    @Test
    fun test_cloud_success_no_cache() = runBlocking {
        val testRemoteDataSource = TestChuksCloudDataSource(returnSuccess = true)
        val testLocalDataSource = TestChuksLocalDataSource(returnSuccess = false)
        val repository = ChuckRepository.ChuckRepositoryImpl(
            testRemoteDataSource,
            testLocalDataSource,
            ChucksCloudMapper.ChucksCloudMapperImpl(TestChuckCloudMapper()),
            ChucksLocalMapper.ChucksLocalMapperImpl(TestChuckLocalMapper())
        )
        val actual = repository.fetchJoke()
        val expected = ChucksData.Success(listOf<Chuck>(
            Chuck(emptyList(), "11.221", "lkjji", "222", "2222", "asd", "asdasd"),
            Chuck(emptyList(), "11.222", "lkjji", "222", "222Э", "asd", "asdasd"),
            Chuck(emptyList(), "11.223", "lkjji", "222", "2222", "asd", "asdasd")
        ))
        assertEquals(actual, expected)
    }

    @Test
    fun test_no_connection_with_cache() = runBlocking {
        val testRemoteDataSource = TestChuksCloudDataSource(returnSuccess = false)
        val testLocalDataSource = TestChuksLocalDataSource(returnSuccess = true)
        val repository = ChuckRepository.ChuckRepositoryImpl(
            testRemoteDataSource,
            testLocalDataSource,
            ChucksCloudMapper.ChucksCloudMapperImpl(TestChuckCloudMapper()),
            ChucksLocalMapper.ChucksLocalMapperImpl(TestChuckLocalMapper())
        )
        val actual = repository.fetchJoke()
        val expected = ChucksData.Success(listOf(
            Chuck(
                id = "22",
                value = "33",
                categories = RealmList<String>(),
                createdAt = "44",
                icon = "55",
                updatedAt = "66",
                url = "77"),
            Chuck(id = "33",
                value = "44",
                categories = RealmList<String>(),
                createdAt = "55",
                icon = "66",
                updatedAt = "77",
                url = "88"),
            Chuck(
                id = "221",
                value = "331",
                categories = RealmList<String>(),
                createdAt = "441",
                icon = "551",
                updatedAt = "661",
                url = "771",
            )))

        assertEquals(expected, actual)
    }

    @Test
    fun test_cloud_success_with_cache() = runBlocking {
        val testRemoteDataSource = TestChuksCloudDataSource(returnSuccess = true)
        val testLocalDataSource = TestChuksLocalDataSource(returnSuccess = true)
        val repository = ChuckRepository.ChuckRepositoryImpl(
            testRemoteDataSource,
            testLocalDataSource,
            ChucksCloudMapper.ChucksCloudMapperImpl(TestChuckCloudMapper()),
            ChucksLocalMapper.ChucksLocalMapperImpl(TestChuckLocalMapper())
        )
        val actual = repository.fetchJoke()
        val expected = ChucksData.Success(listOf(
            Chuck(
                id = "22",
                value = "33",
                categories = RealmList<String>(),
                createdAt = "44",
                icon = "55",
                updatedAt = "66",
                url = "77"),
            Chuck(id = "33",
                value = "44",
                categories = RealmList<String>(),
                createdAt = "55",
                icon = "66",
                updatedAt = "77",
                url = "88"),
            Chuck(
                id = "221",
                value = "331",
                categories = RealmList<String>(),
                createdAt = "441",
                icon = "551",
                updatedAt = "661",
                url = "771",
            )))

        assertEquals(expected, actual)


    }

    private inner class TestChuksCloudDataSource(
        private val returnSuccess: Boolean,
    ) :
        ChuckRemoteDataSource {
        override suspend fun fetchJoke(): List<ChuckCloud> {
            if (returnSuccess) {
                return listOf(
                    ChuckCloud(emptyList(), "11.221", "lkjji", "222", "2222", "asd", "asdasd"),
                    ChuckCloud(emptyList(), "11.222", "lkjji", "222", "222Э", "asd", "asdasd"),
                    ChuckCloud(emptyList(), "11.223", "lkjji", "222", "2222", "asd", "asdasd")
                )
            } else {

                throw unknownHostException
            }
        }

    }

    private inner class TestChuksLocalDataSource(
        private val returnSuccess: Boolean,
    ) : ChuckLocalDataSource {
        override fun fetchJoke(): List<ChuckDB> {
            return if (returnSuccess) {
                listOf(
                    ChuckDB().apply {
                        id = "22"
                        value = "33"
                        categories = RealmList<String>()
                        createdAt = "44"
                        icon = "55"
                        updatedAt = "66"
                        url = "77"

                    },
                    ChuckDB().apply {
                        id = "33"
                        value = "44"
                        categories = RealmList<String>()
                        createdAt = "55"
                        icon = "66"
                        updatedAt = "77"
                        url = "88"
                    },
                    ChuckDB().apply {
                        id = "221"
                        value = "331"
                        categories = RealmList<String>()
                        createdAt = "441"
                        icon = "551"
                        updatedAt = "661"
                        url = "771"
                    },
                )
            } else {
                emptyList()
            }
        }

        override fun saveJoke(jokes: List<Chuck>) {
            //not used
        }
    }



}
