package com.example

import com.example.domain.invoice.*
import java.time.LocalDate

internal class FindInvoiceUseCaseTest {

}

object TestInvoiceFactory {
    fun create(
        invoiceId: InvoiceId = InvoiceId.reconstruct("12345678-90ab-cdef-1234-567890abcdef"),
        clientInvoiceNo: ClientInvoiceNo = ClientInvoiceNo(1),
        totalAmount: TotalAmount = TotalAmount(1111),
        paymentDueBy: PaymentDueBy = PaymentDueBy(LocalDate.parse("2011-01-01")),
        registerDay: RegisterDay = RegisterDay(LocalDate.parse("2011-01-01"))
    ) : Invoice {
        return Invoice.reconstruct(
            invoiceId, clientInvoiceNo, totalAmount, paymentDueBy, registerDay
        )
    }
}
