package com.example.infrastructure

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import org.json.JSONArray
import org.json.JSONObject

class HttpAccessor {
    fun getText(url: String): String {
        val (_, _, result) = url.httpGet().responseString()

        return when (result) {
            is Result.Failure -> {
                val ex = result.getException()
                ex.toString()
            }
            is Result.Success -> {
                result.get()
            }
        }
    }

    fun getJsonObject(url: String): JSONObject {
        val (_, _, result) = url.httpGet().responseJson()

        return when (result) {
            is Result.Failure -> {
                val ex = result.getException()
                JSONObject(mapOf("message" to ex.toString()))
            }
            is Result.Success -> {
                result.get().obj()
            }
        }
    }

    fun getJsonArray(url: String): JSONArray {
        val (_, _, result) = url.httpGet().responseJson()

        return when (result) {
            is Result.Failure -> {
                val ex = result.getException()
                JSONArray(mapOf("message" to ex.toString()))
            }
            is Result.Success -> {
                result.get().array()
            }
        }
    }
}
