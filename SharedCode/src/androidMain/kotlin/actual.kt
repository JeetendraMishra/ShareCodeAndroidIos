package com.hackathon.sharecodeandroidios

actual fun platformName(): String {
    return "Android"
}

actual fun add(c: Int, b: Int): Int {
    return c+b
}
