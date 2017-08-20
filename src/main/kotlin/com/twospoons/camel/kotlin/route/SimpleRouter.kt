package com.twospoons.camel.kotlin.route

import com.twospoons.camel.kotlin.service.SimpleService
import org.apache.camel.builder.RouteBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.apache.camel.LoggingLevel.*

@Component
class SimpleRouter : RouteBuilder() {

    @Autowired
    lateinit var simpleService: SimpleService

    override fun configure() {
        from("direct:test-input")
                .log(DEBUG, log,"Received message on test-input")
                .bean(simpleService, "simpleInputFunction")
                .choice()
                .`when`(header("SEND_OUT").isNotNull)
                    .log(DEBUG, log,"Message is valid and will be sent to direct:test-output")
                    .to("direct:test-output")
                .endChoice()


        from("direct:test-output")
                .log(DEBUG, log, "Received message on test-output")
                .bean(simpleService, "simpleOutputFunction")
                .to("log:out")
    }


}