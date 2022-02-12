package com.example.controller

import com.example.domain.invoice.Invoice
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import java.time.LocalDate

fun Route.greetController() {

    route("/greet") {
        get ("/hello") {
            val invoice = Invoice.create(1, 1000, LocalDate.parse("2022-01-10"))
            call.respond(invoice)
        }
    }

}
