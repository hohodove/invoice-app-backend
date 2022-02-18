package com.example.usecase

import com.example.domain.invoice.Invoice
import com.example.domain.invoice.InvoiceId
import com.example.infrastructure.repository.InvoiceRepository
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.kotlin.onDemand

class GetAllInvoices {
    val jdbi: Jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/test", "admin", "password")
        .installPlugins()

    val dao: InvoiceRepository = jdbi.onDemand<InvoiceRepository>()

    fun getAllInvoice(): List<Invoice> {
        return dao.selectAll()
    }

    fun getInvoice(invoiceId: InvoiceId): Invoice? {
        return dao.selectByInvoiceId(invoiceId)
    }

    fun createInvoice(invoice: Invoice) {
//        dao.insert(invoice1)
    }
}
