package com.example.infrastructure.repository

import com.example.domain.invoice.Invoice
import com.example.domain.invoice.InvoiceId
import org.jdbi.v3.sqlobject.SqlObject
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate

interface InvoiceRepository : SqlObject {

    // JDBIによる自動マッピングのため、プリミティブ型以外の型については、TBLのカラム名は"型名_フィールド名"とする。
    @SqlUpdate("""
       insert into invoices
       (invoiceId_value, clientInvoiceNo, totalAmount, paymentDueBy)
       values (:invoice.invoiceId.value, :invoice.clientInvoiceNo, :invoice.totalAmount, :invoice.paymentDueBy) 
    """)
    fun insert(invoice: Invoice)

    @SqlQuery("select invoiceId_value, clientInvoiceNo, totalAmount, paymentDueBy from invoices")
    fun selectAll(): List<Invoice>

    @SqlQuery("select invoiceId_value, clientInvoiceNo, totalAmount, paymentDueBy from invoices where invoiceId_value = :invoiceId.value")
    fun selectByInvoiceId(invoiceId: InvoiceId): Invoice?
}
