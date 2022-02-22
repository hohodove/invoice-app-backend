package com.example.controller

import com.example.infrastructure.HttpAccessor
import org.json.JSONObject
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class InvoiceControllerKtTest {
    val accessor = HttpAccessor()

    @Test
    fun `請求書取得APIにて請求書IDを指定した場合、請求書情報が返却される`() {
        // given

        // when
        val resultJson = accessor.getJsonObject("http://localhost:8081/invoice/a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11")

        // then
        assertEquals("a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11", resultJson.get("invoiceId"))
        assertEquals(1, resultJson.get("clientInvoiceNo"))
        assertEquals(1000, resultJson.get("totalAmount"))
        assertEquals("2010-01-01", resultJson.get("paymentDueBy"))
        assertEquals("2009-12-31",resultJson.get("registerDay"))
    }

    @Test
    fun `請求書取得APIにて存在しない請求書IDを指定した場合、Not Foundが返却される`() {
        // given

        // when
        val resultText = accessor.getText("http://localhost:8081/invoice/NotFound")

        // then
        assertEquals("Not Found", resultText)
    }

    @Test
    fun `請求書一覧取得APIを呼び出すと、2件以上の請求書情報が返却される`() {
        // given

        // when
        val result = accessor.getJsonArray("http://localhost:8081/invoices")

        // then
        val resultObject1 = result[0] as JSONObject
        val resultObject2 = result[1] as JSONObject
        assertNotNull(resultObject1)
        assertNotNull(resultObject2)
        val pattern = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}".toRegex()
        assertTrue(resultObject1.get("invoiceId").toString().matches(pattern))
        assertTrue(resultObject2.get("invoiceId").toString().matches(pattern))
    }
}
