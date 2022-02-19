package com.example.infrastructure.repository

import com.example.domain.invoice.Invoice
import com.example.domain.invoice.InvoiceId
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.kotlin.onDemand

class InvoiceRepository {
    fun findByInvoiceId(invoiceId: InvoiceId): Invoice {
        val jdbi: Jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/test", "admin", "password")
            .installPlugins()

        val dao: InvoiceRepositoryInterface = jdbi.onDemand<InvoiceRepositoryInterface>()

        return dao.findByInvoiceId(invoiceId)

    }
}
