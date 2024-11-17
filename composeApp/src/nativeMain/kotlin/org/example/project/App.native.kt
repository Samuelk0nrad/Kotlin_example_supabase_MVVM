package org.example.project

actual fun printLog(tag: String, message: String) {
    println("$tag: $message")
}