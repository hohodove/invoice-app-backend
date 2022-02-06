package com.example.controller

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.greetController() {

    route("/greet") {
        get ("/hello") {
            call.respondText { "Hello!" }
        }
    }

}
