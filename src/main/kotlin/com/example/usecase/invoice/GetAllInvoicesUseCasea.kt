package com.example.usecase.invoice

import com.example.domain.invoice.Invoice
import com.example.infrastructure.repository.InvoiceRepository

class GetAllInvoicesUseCase {
    val invoiceRepository = InvoiceRepository()

    fun execute(): List<InvoiceDto> {
        val result = invoiceRepository.getAllinvoices()
        return InvoiceDto.toList(result)
    }
}
