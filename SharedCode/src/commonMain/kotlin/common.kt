package com.hackathon.sharecodeandroidios

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