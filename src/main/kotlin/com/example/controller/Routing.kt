package com.example.controller

import io.ktor.routing.*
import io.ktor.application.*

fun Application.Routing() {

    routing {
        greetController()
    }
}
