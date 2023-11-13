package com.nikolaenko.playground.core.logger

import android.util.Log

object Logger {

    fun d(message: String) {
        if (true) {
            Log.d(TAG, message)
        }
    }

    fun v(message: String) {
        if (true) {
            Log.v(TAG, message)
        }
    }

    fun w(message: String) {
        if (true) {
            Log.w(TAG, message)
        }
    }

    fun e(t: Throwable) {
        if (true) {
            Log.e(TAG, "", t)
        }
    }

    const val TAG = "PlaygroundTag"
}