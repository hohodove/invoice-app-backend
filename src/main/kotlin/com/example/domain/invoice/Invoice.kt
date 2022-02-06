package com.example.domain.invoice

import java.time.LocalDate

class Invoice private constructor(
    val invoiceId: Int,
    val clientInvoiceNo: Int,
    val totalAmount: Int,
    val paymentDueBy: LocalDate
) {
    companion object {
        fun create(clientInvoiceNo: Int, totalAmount: Int, paymentDueBy: LocalDate): Invoice {
            return Invoice(
                invoiceId = InvoiceId.numbering(),
                clientInvoiceNo = clientInvoiceNo,
                totalAmount = totalAmount,
                paymentDueBy = paymentDueBy
            )
        }
    }
}

object InvoiceId {
    var id: Int = 0
        private set

    fun numbering(): Int = ++id
}
