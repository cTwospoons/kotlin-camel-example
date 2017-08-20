package com.twospoons.camel.kotlin.controller

import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleController {

    companion object: KLogging()

    @GetMapping("/simple")
    fun simple(): String {
        logger.debug { "invoking /simple endpoint" }

        return "Hello, World!"
    }


}
