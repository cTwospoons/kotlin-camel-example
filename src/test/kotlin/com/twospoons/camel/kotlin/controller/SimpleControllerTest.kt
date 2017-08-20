package com.twospoons.camel.kotlin.controller

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@RunWith(MockitoJUnitRunner::class)
class SimpleControllerTest {

    @InjectMocks
    lateinit var simpleController: SimpleController

    @Test
    fun testSimpleEndpoint(){
        val result = simpleController.simple()

        assertNotNull(result)
        assertEquals("Hello, World!", result)
    }
}
