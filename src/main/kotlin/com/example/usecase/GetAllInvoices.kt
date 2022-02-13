package com.example.usecase

import com.example.domain.invoice.Invoice
import com.example.infrastructure.repository.InvoiceRepository
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.postgres.PostgresPlugin
import org.jdbi.v3.sqlobject.kotlin.KotlinSqlObjectPlugin
import org.jdbi.v3.sqlobject.kotlin.onDemand
import java.time.LocalDate

class GetAllInvoices {
    val jdbi: Jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/test", "admin", "password")
        .installPlugin(KotlinSqlObjectPlugin())
        .installPlugin(KotlinPlugin())
        .installPlugin(PostgresPlugin())

    val dao: InvoiceRepository = jdbi.onDemand<InvoiceRepository>()

    val invoice1 = Invoice.create(222, 2000, LocalDate.parse("2020-02-02"))

    fun getAllInvoice() : List<Invoice> {
        dao.insert(invoice1)

        val invoices: List<Invoice> = dao.selectAll()
        return invoices
    }
}
