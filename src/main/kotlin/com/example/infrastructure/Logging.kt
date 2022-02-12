package com.example.infrastructure

import io.ktor.request.*
import org.slf4j.event.Level
import io.ktor.application.*
import io.ktor.features.*

fun Application.logging() {
    install(CallLogging) {
        level = Level.INFO
        format { call ->
            val status = call.response.status()
            val httpMethod = call.request.httpMethod.value
            val requestPass = call.request.path()
            val queryString = call.request.queryString()
            val cookies = call.request.cookies.rawCookies
            "Status: $status, HTTP method: $httpMethod, RequestPath: $requestPass, " +
                    "QueryString: $queryString, Cookies: $cookies"
        }
    }
}
