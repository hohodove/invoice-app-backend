package com.example.controller

import com.example.usecase.GetAllInvoices
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.invoiceController() {
    get("/invoices") {
        val getAllInvoices = GetAllInvoices()
        val invoices = getAllInvoices.getAllInvoice()
        call.respond(invoices)
    }

    get("/invoices/{invoiceId}") {
        //TODO 実装
    }

    post("/invoices") {
        //TODO 実装
    }

    put("/invoices/{invoiceId") {
        //TODO 実装
    }

    delete("/invoices/{invoiceId") {
        //TODO 実装
    }
}
