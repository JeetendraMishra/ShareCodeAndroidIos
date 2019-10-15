package com.hackathon.sharecodeandroidios

import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.content.TextContent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

expect fun platformName(): String
expect fun add(c: Int, b: Int): Int

fun createApplicationScreenMessage(): String {
    return "Kotlin Rocks on ${platformName()}"
}

fun sum(c: Int, b: Int): String {
    return "Result is : ${add(c,b)}"
}

fun isEmailValid(email: String): Boolean {
    var isValid = false

    if (!email.isNullOrEmpty()) {
        val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        isValid = EMAIL_REGEX.toRegex().matches(email)
    }

    return isValid
}

fun isPasswordValid(password: String): Boolean {
    var isValid = false

    if (!password.isNullOrEmpty()) {
        val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@.#\$%!\\-_?&])(?=\\S+\$).{8,}"
        isValid = PASSWORD_REGEX.toRegex().matches(password)
    }

    return isValid
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