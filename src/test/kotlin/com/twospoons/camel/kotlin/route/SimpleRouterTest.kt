package com.twospoons.camel.kotlin.route

import com.twospoons.camel.kotlin.service.SimpleService
import org.apache.camel.ProducerTemplate
import org.apache.camel.builder.AdviceWithRouteBuilder
import org.apache.camel.component.mock.MockEndpoint
import org.apache.camel.impl.DefaultCamelContext
import org.apache.camel.model.ModelCamelContext
import org.apache.camel.model.RouteDefinition
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SimpleRouterTest {

    @InjectMocks
    lateinit var router: SimpleRouter

    @Mock
    lateinit var simpleService: SimpleService

    lateinit var camelContext: ModelCamelContext
    lateinit var mockedEndpoint: MockEndpoint
    lateinit var producerTemplate: ProducerTemplate


    @Before
    fun setup(){
        camelContext = DefaultCamelContext()

        camelContext.addRoutes(router)
        camelContext.start()

        for (routeDefiniton: RouteDefinition in camelContext.routeDefinitions.toList()){
            routeDefiniton.adviceWith(camelContext, object: AdviceWithRouteBuilder() {
                override fun configure(){
                    mockEndpointsAndSkip("log:out")
                }
            })
        }

        mockedEndpoint = MockEndpoint.resolve(camelContext, "mock:log:out")
        producerTemplate = camelContext.createProducerTemplate()
    }

    @After
    fun cleanup(){
        mockedEndpoint.reset()
        camelContext.stop()
    }

    @Test
    fun testRouteInput(){
        mockedEndpoint.expectedMessageCount(0)
        producerTemplate.sendBody("direct:test-input", "")

        mockedEndpoint.assertIsSatisfied()
    }

    @Test
    fun testRouteInputWithHeader(){
        mockedEndpoint.expectedMessageCount(1)
        producerTemplate.sendBodyAndHeader("direct:test-input", "", "SEND_OUT", true)

        mockedEndpoint.assertIsSatisfied()
    }
}
