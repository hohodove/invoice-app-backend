package com.example.infrastructure.repository

import com.example.domain.invoice.Invoice
import com.example.domain.invoice.InvoiceId
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.kotlin.onDemand

class InvoiceRepository {
    val jdbi: Jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/test", "admin", "password")
        .installPlugins()

    val dao: InvoiceRepositoryInterface = jdbi.onDemand<InvoiceRepositoryInterface>()

    fun findByInvoiceId(invoiceId: InvoiceId): Invoice {
        return dao.findByInvoiceId(invoiceId)
    }

    fun getAllinvoices(): List<Invoice> {
        return dao.getAll()
    }
}
