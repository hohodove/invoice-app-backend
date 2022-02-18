package com.example.controller

import com.example.usecase.invoice.GetAllInvoicesUsecase
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.invoiceController() {
    get("/invoices") {
        val getAllInvoicesUsecase = GetAllInvoicesUsecase()
        val invoices = getAllInvoicesUsecase.getAllInvoice()
        call.respond(invoices)
    }

    get("/invoice/{invoiceId}") {
        //TODO 実装
    }

    post("/invoice") {
        //TODO 実装
    }

    put("/invoice/{invoiceId") {
        //TODO 実装
    }

    delete("/invoice/{invoiceId") {
        //TODO 実装
    }
}
