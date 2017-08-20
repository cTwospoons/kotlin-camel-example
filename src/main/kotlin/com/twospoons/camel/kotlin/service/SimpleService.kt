package com.twospoons.camel.kotlin.service

import mu.KLogging
import org.springframework.stereotype.Component

@Component
class SimpleService {
    companion object: KLogging()

    fun simpleInputFunction(input: String): String{
        logger.debug { "Simple Input Function invoked with argument: $input" }

        var returnString = "$input -- altered String"

        return returnString
    }

    fun simpleOutputFunction(output: String): String{
        logger.debug { "Simple Output Function invoked with argument: $output" }

        var returnString = "$output -- altered String"

        return returnString
    }
}
