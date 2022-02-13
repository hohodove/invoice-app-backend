package com.example.controller

import com.example.usecase.GetAllInvoices
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.invoiceController() {
    route("/invoice") {
        get("/all") {
            val getAllInvoices = GetAllInvoices()
            val invoices = getAllInvoices.getAllInvoice()
            call.respond(invoices)
        }
    }
}
