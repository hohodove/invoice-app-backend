package com.example.infrastructure

import com.example.controller.Routing
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.request.*
import org.slf4j.event.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {

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

    Routing()
}
