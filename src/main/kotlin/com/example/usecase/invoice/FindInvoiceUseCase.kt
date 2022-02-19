package com.example.usecase.invoice

import com.example.domain.invoice.Invoice
import com.example.domain.invoice.InvoiceId
import com.example.infrastructure.repository.InvoiceRepository

class FindInvoiceUseCase {

    val invoiceRepository: InvoiceRepository = InvoiceRepository()

    fun execute(invoiceId: InvoiceId): Invoice {
        return invoiceRepository.findByInvoiceId(invoiceId)
    }
}
