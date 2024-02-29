package org.proyectii

import com.fasterxml.jackson.databind.DeserializationFeature.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature.*
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ProyectiiApplication {

    @Bean
    fun objectMapper(): ObjectMapper =
        jacksonObjectMapper()
            .registerKotlinModule()
            .registerModule(JavaTimeModule())
            .disable(FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(READ_UNKNOWN_ENUM_VALUES_AS_NULL)
            .disable(WRITE_DATES_AS_TIMESTAMPS)

}

fun main(args : Array<String>) {
    runApplication<ProyectiiApplication>(*args)
}