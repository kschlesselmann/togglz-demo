package com.example.demo.actuate

import org.springframework.boot.actuate.endpoint.annotation.Endpoint
import org.springframework.boot.actuate.endpoint.annotation.Selector
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation
import org.springframework.stereotype.Component

@Component
@Endpoint(id = "custom")
class CustomTestEndpoint {

    @WriteOperation
    fun doCustomStuff(@Selector name: String, enabled: Boolean) {
        println("$name is now $enabled")
    }

}
