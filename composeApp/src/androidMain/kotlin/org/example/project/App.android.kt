package org.example.project

import android.util.Log

actual fun printLog(tag: String, message: String) {
    Log.d(tag, message)
}
