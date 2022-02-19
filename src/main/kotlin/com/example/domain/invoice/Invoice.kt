package com.example.domain.invoice

import org.jdbi.v3.core.mapper.Nested
import org.jdbi.v3.core.mapper.reflect.ColumnName
import java.time.LocalDate
import java.util.UUID

class Invoice private constructor(
    @Nested val invoiceId: InvoiceId,
    @Nested val clientInvoiceNo: ClientInvoiceNo,
    @Nested val totalAmount: TotalAmount,
    @Nested val paymentDueBy: PaymentDueBy,
    @Nested val registerDay: RegisterDay
) {
    companion object {
        fun create(
            invoiceId: InvoiceId = InvoiceId.create(),
            clientInvoiceNo: ClientInvoiceNo,
            totalAmount: TotalAmount,
            paymentDueBy: PaymentDueBy,
            registerDay: RegisterDay = RegisterDay(LocalDate.now())
        ): Invoice {
            if (paymentDueBy.value.isBefore(registerDay.value)) {
                throw IllegalArgumentException("支払期限(${paymentDueBy.value.toString()})が登録日(${registerDay.value.toString()})より過去です。")
            }

            return Invoice(
                invoiceId = invoiceId,
                clientInvoiceNo = clientInvoiceNo,
                totalAmount = totalAmount,
                paymentDueBy = paymentDueBy,
                registerDay = registerDay
            )
        }

        fun reconstruct(
            invoiceId: InvoiceId,
            clientInvoiceNo: ClientInvoiceNo,
            totalAmount: TotalAmount,
            paymentDueBy: PaymentDueBy,
            registerDay: RegisterDay
        ): Invoice {
            return Invoice(invoiceId, clientInvoiceNo, totalAmount, paymentDueBy, registerDay)
        }
    }
}

class InvoiceId private constructor(
    @ColumnName("invoice_id") val value: String = UUID.randomUUID().toString()
) {
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

data class PaymentDueBy(@ColumnName("payment_due_by") val value: LocalDate)

data class RegisterDay(@ColumnName("register_day") val value: LocalDate)
