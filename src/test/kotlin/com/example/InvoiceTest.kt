package com.example

import com.example.domain.invoice.ClientInvoiceNo
import com.example.domain.invoice.Invoice
import com.example.domain.invoice.PaymentDueBy
import com.example.domain.invoice.TotalAmount
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import org.junit.rules.ExpectedException
import java.time.LocalDate
import kotlin.test.assertEquals

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
        assertEquals(LocalDate.now(), successInvoice.registerDay.value)
        assertEquals(clientInvoiceNo, successInvoice.clientInvoiceNo)
        assertEquals(totalAmount, successInvoice.totalAmount)
        assertEquals(paymentDueBy, successInvoice.paymentDueBy)
    }

    @Test
    fun `請求書を新規作成時、請求期限が当日より過去の場合、エラーとする`() {
        // given

        // when
        val today = LocalDate.now()
        val yesterday = LocalDate.now().minusDays(1)

        val clientInvoiceNo = ClientInvoiceNo(1)
        val totalAmount = TotalAmount(1111)
        val paymentDueBy = PaymentDueBy(yesterday)

        val target: () -> Unit = {
            val errorInvoice = Invoice.create(
                clientInvoiceNo = clientInvoiceNo,
                totalAmount = totalAmount,
                paymentDueBy = paymentDueBy)
        }

        // then
        val exception = assertThrows<IllegalArgumentException>(target)
        assertEquals("支払期限($yesterday)が登録日($today)より過去です。", exception.message)
    }
}

