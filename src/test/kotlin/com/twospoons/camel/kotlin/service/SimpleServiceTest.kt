package com.twospoons.camel.kotlin.service

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.runners.MockitoJUnitRunner
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@RunWith(MockitoJUnitRunner::class)
class SimpleServiceTest {

    @InjectMocks
    lateinit var service: SimpleService

    @Test
    fun testInputFunction(){
        var returned = service.simpleInputFunction("simple input")

        assertNotNull(returned)
        assertEquals("simple input -- altered String", returned)
    }

    @Test
    fun testOutputFunction(){
        var returned = service.simpleOutputFunction("simple output")

        assertNotNull(returned)
        assertEquals("simple output -- altered String", returned)
    }
}
