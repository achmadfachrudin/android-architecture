package com.project.app.feature.main.presentation

import com.project.data.module.networkModule
import com.project.data.service.MainService
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class MainActivityTest: KoinTest {

    private val service: MainService by inject()

    @Before
    fun setUp() {
        startKoin{
            modules(networkModule)
        }
    }

    @Test
    fun getMenuFromApi() {
        // expected
        val expectedResult = "Addition"

        // actual
        val actualResult = runBlocking {
            service.getMenuAsync().await()
        }.body()

        Assert.assertEquals(expectedResult, actualResult?.menu?.get(0)?.title)
    }
}