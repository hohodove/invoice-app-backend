package com.example

import com.example.domain.invoice.ClientInvoiceNo
import com.example.domain.invoice.Invoice
import com.example.domain.invoice.PaymentDueBy
import com.example.domain.invoice.TotalAmount
import org.junit.Test
import java.time.LocalDate

internal class InvoiceTest {
    @Test
    fun `新しく請求書を作成すると、請求書IDはUUID形式、登録日は当日のインスタンスが生成される`() {
        // given(前提条件)

        // when(操作)
        val clientInvoiceNo = ClientInvoiceNo(1)
        val totalAmount = TotalAmount(1111)
        val paymentDueBy = PaymentDueBy(LocalDate.now())

        val successInvoice = Invoice.create(
            clientInvoiceNo = clientInvoiceNo,
            totalAmount = totalAmount,
            paymentDueBy = paymentDueBy)

        // then(期待する結果)
        val pattern = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}".toRegex()
        kotlin.test.assertTrue(successInvoice.invoiceId.value.matches(pattern))
        kotlin.test.assertEquals(LocalDate.now(), successInvoice.registerDay.value)
        kotlin.test.assertEquals(clientInvoiceNo, successInvoice.clientInvoiceNo)
        kotlin.test.assertEquals(totalAmount, successInvoice.totalAmount)
        kotlin.test.assertEquals(paymentDueBy, successInvoice.paymentDueBy)
    }
}


