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
//            val invoice = getAllInvoices.getInvoice(InvoiceId.reconstruct("ad4a1759-5438-4c9f-8926-068bcd5add96"))
            call.respond(invoices)
        }
    }
}
