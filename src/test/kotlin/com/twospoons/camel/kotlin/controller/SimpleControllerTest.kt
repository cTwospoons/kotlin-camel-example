package com.twospoons.camel.kotlin.controller

import org.apache.camel.ProducerTemplate
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@RunWith(MockitoJUnitRunner::class)
class SimpleControllerTest {

    @InjectMocks
    lateinit var simpleController: SimpleController

    @Mock
    lateinit var producerTemplate: ProducerTemplate


    @Test
    fun testSimpleEndpoint(){
        val result = simpleController.simple()

        assertNotNull(result)
        assertEquals("Hello, World!", result)
    }

    @Test
    fun testCamelEndpoint(){
        val result = simpleController.camel()

        assertNotNull(result)
        assertEquals("", result)
    }

    @Test
    fun testCamelWithHeaderEndpoint(){
        val result = simpleController.camelWithHeader()

        assertNotNull(result)
        assertEquals("", result)
    }
}
