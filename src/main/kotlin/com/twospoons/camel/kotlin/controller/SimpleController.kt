package com.twospoons.camel.kotlin.controller

import mu.KLogging
import org.apache.camel.Produce
import org.apache.camel.ProducerTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleController {

    companion object: KLogging()

    @Produce(uri = "direct:test-input")
    lateinit var producerTemplate: ProducerTemplate

    @GetMapping("/simple")
    fun simple(): String {
        logger.debug { "invoking /simple endpoint" }
        val returned = "Hello, World!"

        return returned
    }

    @GetMapping("/camel")
    fun camel(): String {
        logger.debug { "invoking /camel endpoint" }

        producerTemplate.sendBody( "test" )

        return ""
    }

    @GetMapping("/camel/header")
    fun camelWithHeader(): String {
        logger.debug { "invoking /camel/header endpoint" }

        producerTemplate.sendBodyAndHeader( "test", "SEND_OUT", true )

        return ""
    }


}
