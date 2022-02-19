package com.example.usecase.invoice

import com.example.domain.invoice.Invoice
import com.example.infrastructure.repository.InvoiceRepositoryInterface
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.kotlin.onDemand

class GetAllInvoicesUseCasea {
    val jdbi: Jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/test", "admin", "password")
        .installPlugins()

    val dao: InvoiceRepositoryInterface = jdbi.onDemand<InvoiceRepositoryInterface>()

    fun execute(): List<Invoice> {
        return emptyList()
    }

}

//data class InvoiceDto(
//    val invoice: List<Invoice>
//)
