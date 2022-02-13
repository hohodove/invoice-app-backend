package com.example.domain.invoice

import java.time.LocalDate
import java.util.UUID

class Invoice private constructor(
    val invoiceId: String,
    val clientInvoiceNo: Int,
    val totalAmount: Int,
    val paymentDueBy: LocalDate
) {
    companion object {
        fun create(clientInvoiceNo: Int, totalAmount: Int, paymentDueBy: LocalDate): Invoice {
            return Invoice(
                invoiceId = UUID.randomUUID().toString(),
                clientInvoiceNo = clientInvoiceNo,
                totalAmount = totalAmount,
                paymentDueBy = paymentDueBy
            )
        }
    }
}
