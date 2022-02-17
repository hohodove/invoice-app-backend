package com.example.domain.invoice

import java.time.LocalDate
import java.util.UUID

class Invoice private constructor(
    val invoiceId: InvoiceId = InvoiceId.create(),
    val clientInvoiceNo: Int,
    val totalAmount: Int,
    val paymentDueBy: LocalDate
) {
    companion object {
        fun create(clientInvoiceNo: Int, totalAmount: Int, paymentDueBy: LocalDate): Invoice {
            return Invoice(
                clientInvoiceNo = clientInvoiceNo,
                totalAmount = totalAmount,
                paymentDueBy = paymentDueBy
            )
        }
    }
}

class InvoiceId private constructor(val value: String = UUID.randomUUID().toString()) {
    companion object {
        fun create(): InvoiceId {
            return InvoiceId()
        }

        fun reconstruct(value: String): InvoiceId {
            return InvoiceId(value)
        }
    }
}
