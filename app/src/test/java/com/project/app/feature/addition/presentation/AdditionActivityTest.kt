package com.project.app.feature.addition.presentation

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class AdditionActivityTest {

    @Mock
    lateinit var additionActivity: AdditionActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        additionActivity = AdditionActivity()
    }

    @Test
    fun testResultAddition() {

        // expected
        val expectedResult = 7

        // actual
        val actualResult = additionActivity.resultAddition(3, 4)

        Assert.assertEquals(expectedResult, actualResult)
    }
}