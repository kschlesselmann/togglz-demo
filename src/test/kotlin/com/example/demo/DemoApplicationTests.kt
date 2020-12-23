package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class DemoApplicationTests(
    @Autowired private val webTestClient: WebTestClient
) {

    @Test
    fun `should invoke custom endpoint`() {
        
        webTestClient.post()
            .uri("/actuator/custom/{name}", "TEST")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue("{\"enabled\":true}")
            .exchange()
            .expectStatus().isNoContent

    }

    @Test
    fun `should invoke togglz endpoint`() {

        webTestClient.post()
            .uri("/actuator/togglz/{name}", "TEST")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue("{\"enabled\":true}")
            .exchange()
            .expectStatus().isOk

    }

}
