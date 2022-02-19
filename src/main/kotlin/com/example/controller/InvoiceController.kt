package com.example.controller

import com.example.domain.invoice.Invoice
import com.example.domain.invoice.InvoiceId
import com.example.usecase.invoice.FindInvoiceDto
import com.example.usecase.invoice.FindInvoiceUseCase
import com.example.usecase.invoice.GetAllInvoicesUseCasea
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.invoiceController() {
    get("/invoices") {
        val getAllInvoicesUseCase = GetAllInvoicesUseCasea()
        val invoices = getAllInvoicesUseCase.execute()
        call.respond(invoices)
    }

    get("/invoice/{invoiceId}") {
        // パスパラメータを指定しない場合、以下のIllegalArgumentExceptionではなく、404 NotFoundとなる。
        val pathparameter: String = call.parameters["invoiceId"] ?: throw IllegalArgumentException("Path parameter is null.")

        val invoiceId = InvoiceId.reconstruct(pathparameter)
        val findInvoiceUseCase = FindInvoiceUseCase()
        val invoice = findInvoiceUseCase.execute(invoiceId)
        call.respond(invoice ?: "Not Found")
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
