package com.twospoons.camel.kotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleController {

    @GetMapping("/simple")
    fun simple() =
            "Hello, World!"

}
