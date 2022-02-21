package com.example.usecase.invoice

import com.example.domain.invoice.*
import com.example.infrastructure.repository.InvoiceRepository
import java.time.LocalDate

class FindInvoiceUseCase {

    val invoiceRepository: InvoiceRepository = InvoiceRepository()

    fun execute(invoiceId: InvoiceId): InvoiceDto? {
        val result = invoiceRepository.findByInvoiceId(invoiceId)
        return result?.let{ InvoiceDto(it) }
    }
}

data class InvoiceDto(
    val invoiceId: String,
    val clientInvoiceNo: Int,
    val totalAmount: Int,
    val paymentDueBy: LocalDate,
    val registerDay: LocalDate
) {
    constructor(invoice: Invoice) : this(
        invoiceId = invoice.invoiceId.value,
        clientInvoiceNo = invoice.clientInvoiceNo.value,
        totalAmount = invoice.totalAmount.value,
        paymentDueBy = invoice.paymentDueBy.value,
        registerDay = invoice.registerDay.value
    )

    companion object {
        fun toList(invoices: List<Invoice>): List<InvoiceDto> {
            return invoices.map { InvoiceDto(it) }
        }
    }
}
