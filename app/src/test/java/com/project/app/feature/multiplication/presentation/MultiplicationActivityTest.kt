package com.project.app.feature.multiplication.presentation

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MultiplicationActivityTest {

    @Mock
    lateinit var multiplicationActivity: MultiplicationActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        multiplicationActivity = MultiplicationActivity()
    }

    @Test
    fun testResultMultiplication() {

        // expected
        val expectedResult = 12

        // actual
        val actualResult = multiplicationActivity.resultMultiplication(3, 4)

        Assert.assertEquals(expectedResult, actualResult)
    }
}