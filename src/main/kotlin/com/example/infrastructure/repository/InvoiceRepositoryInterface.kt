package com.example.infrastructure.repository

import com.example.domain.invoice.Invoice
import com.example.domain.invoice.InvoiceId
import org.jdbi.v3.sqlobject.SqlObject
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import java.util.Optional

interface InvoiceRepositoryInterface : SqlObject {

    @SqlQuery("""
        select *
        from invoices
        where invoice_id = :invoiceId.value
    """)
    fun findByInvoiceId(invoiceId: InvoiceId): Invoice

    @SqlQuery("select * from invoices")
    fun getAll(): List<Invoice>

    @SqlUpdate("""
       insert into invoices
       (invoice_id, client_invoice_id, total_amount, payment_due_by)
       values (:invoice.invoiceId.value, :invoice.clientInvoiceNo, :invoice.totalAmount, :invoice.paymentDueBy) 
    """)
    fun register(invoice: Invoice)

}
