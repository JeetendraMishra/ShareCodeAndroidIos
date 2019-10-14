package com.hackathon.sharecodeandroidios

expect fun platformName(): String
expect fun add(c: Int, b: Int): Int

fun createApplicationScreenMessage(): String {
    return "Kotlin Rocks on ${platformName()}"
}

fun sum(c: Int, b: Int): String {
    return "Result is : ${add(c,b)}"
}