package com.example.infrastructure

import com.example.controller.invoiceController
import io.ktor.routing.*
import io.ktor.application.*

fun Application.routing() {
    routing {
        invoiceController()
    }
}
