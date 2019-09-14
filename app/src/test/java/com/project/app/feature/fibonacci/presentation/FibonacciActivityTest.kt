package com.project.app.feature.fibonacci.presentation

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class FibonacciActivityTest {

    @Mock
    lateinit var fibonacciActivity: FibonacciActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        fibonacciActivity = FibonacciActivity()
    }

    @Test
    fun testListFibonacci() {

        // expected
        val expectedResult = "0, 1, 1"

        // actual
        val actualResult = fibonacciActivity.listFibonacci(3)

        Assert.assertEquals(expectedResult, actualResult)
    }
}