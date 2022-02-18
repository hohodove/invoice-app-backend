package com.example.domain.invoice

import org.jdbi.v3.core.mapper.Nested
import org.jdbi.v3.core.mapper.reflect.ColumnName
import java.time.LocalDate
import java.util.UUID

class Invoice private constructor(
    @Nested val invoiceId: InvoiceId = InvoiceId.create(),
    @Nested val clientInvoiceNo: ClientInvoiceNo,
    @Nested val totalAmount: TotalAmount,
    @Nested val paymentDueBy: PaymentDueBy
) {
    companion object {
        fun create(clientInvoiceNo: ClientInvoiceNo, totalAmount: TotalAmount, paymentDueBy: PaymentDueBy): Invoice {
            return Invoice(
                clientInvoiceNo = clientInvoiceNo,
                totalAmount = totalAmount,
                paymentDueBy = paymentDueBy
            )
        }

        fun reconstruct(invoiceId: InvoiceId, clientInvoiceNo: ClientInvoiceNo, totalAmount: TotalAmount, paymentDueBy: PaymentDueBy): Invoice {
            return Invoice(invoiceId, clientInvoiceNo, totalAmount, paymentDueBy)
        }
    }
}

class InvoiceId private constructor(@ColumnName("invoice_id") val value: String = UUID.randomUUID().toString()) {
    companion object {
        fun create(): InvoiceId {
            return InvoiceId()
        }

        fun reconstruct(value: String): InvoiceId {
            return InvoiceId(value)
        }
    }
}

data class ClientInvoiceNo(@ColumnName("client_invoice_no") val value: Int)

data class TotalAmount(@ColumnName("total_amount") val value: Int)

data class PaymentDueBy(@ColumnName("payment_due_by") val value: LocalDate) {
    init {
        val yestaday = LocalDate.now().minusDays(1)
        if (!value.isAfter(yestaday)) throw java.lang.IllegalArgumentException("支払期限が過去日付です。")
    }
}
