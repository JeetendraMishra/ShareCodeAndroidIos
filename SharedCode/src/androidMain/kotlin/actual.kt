package com.hackathon.sharecodeandroidios

import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.content.TextContent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

actual fun platformName(): String {
    return "Android"
}

actual fun add(c: Int, b: Int): Int {
    return c+b
}

fun callLogin(email: String, password: String): String{

    var result = ""
    val job = GlobalScope.launch {
        val client = HttpClient()
        val response = client.call("https://api-stage.hmnow.com/svod-facade/v1/deviceactivation/activate") {
            method = HttpMethod.Post
            body = TextContent("{\n" +
                    "  \"email\": \""+email+"\",\n" +
                    "  \"password\": \""+password+"\",\n" +
                    "  \"device_type\": \"android\"\n" +
                    "}", contentType = ContentType.Application.Json)
        }.response

        result = response.status.value.toString()
    }
    while (!job.isCompleted) {

    }
    return result
}