package com.example.infrastructure.repository

import com.example.domain.invoice.Invoice
import org.jdbi.v3.sqlobject.SqlObject
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate

interface InvoiceRepository : SqlObject {

    @GetGeneratedKeys
    @SqlUpdate(
        "insert into invoices (invoiceId, clientInvoiceNo, totalAmount, paymentDueBy) " +
                "values (:invoice.invoiceId, :invoice.clientInvoiceNo, :invoice.totalAmount, :invoice.paymentDueBy)"
    )
    fun insert(invoice: Invoice) : Invoice

    @SqlQuery("select invoiceId, clientInvoiceNo, totalAmount, paymentDueBy from invoices")
    fun selectAll() : List<Invoice>
}
