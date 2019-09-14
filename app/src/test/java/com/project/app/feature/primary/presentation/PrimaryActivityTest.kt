package com.project.app.feature.primary.presentation

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class PrimaryActivityTest {

    @Mock
    lateinit var primaryActivity: PrimaryActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        primaryActivity = PrimaryActivity()
    }

    @Test
    fun testIsPrimaryNumber() {

        // expected
        val expectedResult = true

        // actual
        val actualResult = primaryActivity.isPrimaryNumber(7)

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun testListPrimary() {

        // expected
        val expectedResult = "2, 3, 5"

        // actual
        val actualResult = primaryActivity.listPrimaryNumber(3)

        Assert.assertEquals(expectedResult, actualResult)
    }
}