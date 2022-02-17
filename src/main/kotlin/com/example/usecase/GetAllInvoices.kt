package com.example.usecase

import com.example.domain.invoice.Invoice
import com.example.domain.invoice.InvoiceId
import com.example.infrastructure.repository.InvoiceRepository
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.postgres.PostgresPlugin
import org.jdbi.v3.sqlobject.kotlin.onDemand
import java.time.LocalDate

class GetAllInvoices {

    val jdbi: Jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/test", "admin", "password")
        .installPlugins()
        .installPlugin(PostgresPlugin())

    val dao: InvoiceRepository = jdbi.onDemand<InvoiceRepository>()

    val invoice1 = Invoice.create(444, 2000, LocalDate.parse("2020-02-02"))

    fun getAllInvoice(): List<Invoice> {
        dao.insert(invoice1)

        return dao.selectAll()
    }

    fun getInvoice(invoiceId: InvoiceId): Invoice? {
        dao.insert(invoice1)

        return dao.selectByInvoiceId(invoiceId)
    }
}
