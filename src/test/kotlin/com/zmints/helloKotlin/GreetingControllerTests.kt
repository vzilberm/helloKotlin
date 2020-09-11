package com.zmints.helloKotlin

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerTests(@Autowired val restTemplate: TestRestTemplate) {

    @BeforeEach
    fun setUp() {
        println ("****** Setting Up!")
    }

    @Test
    fun greetings_default_name() {
        println(">> Assert content and status code")
        val entity = restTemplate.getForEntity<String>("/greetings")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("Hello, World")
    }

    @Test
    fun greetings_happy() {
        println(">> Assert content and status code")
        val entity = restTemplate.getForEntity<String>("/greetings?name=Nakib")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("Hello, Nakib")
    }
}