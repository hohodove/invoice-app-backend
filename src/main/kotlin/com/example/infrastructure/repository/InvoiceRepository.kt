package com.example.infrastructure.repository

import com.example.domain.invoice.Invoice
import com.example.domain.invoice.InvoiceId
import org.jdbi.v3.sqlobject.SqlObject
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate

interface InvoiceRepository : SqlObject {

    @SqlUpdate("""
       insert into invoices
       (invoiceId, clientInvoiceNo, totalAmount, paymentDueBy)
       values (:invoice.invoiceId.value, :invoice.clientInvoiceNo, :invoice.totalAmount, :invoice.paymentDueBy) 
    """)
    fun insert(invoice: Invoice)

    @SqlQuery("select * from invoices")
    fun selectAll(): List<Invoice>

    @SqlQuery("""
        select
        invoiceId, clientInvoiceNo, totalAmount, paymentDueBy
        from invoices
        where invoiceId = :invoiceId.value"
    """)
    fun selectByInvoiceId(invoiceId: InvoiceId): Invoice?
}
