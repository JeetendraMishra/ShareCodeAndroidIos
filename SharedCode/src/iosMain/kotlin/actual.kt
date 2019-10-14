package com.hackathon.sharecodeandroidios

import platform.UIKit.UIDevice

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName() +
            " Jeet " +
            UIDevice.currentDevice.systemVersion
}

actual fun add(c: Int, b: Int): Int {
    return c+b
}