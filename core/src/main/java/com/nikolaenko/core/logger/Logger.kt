package com.nikolaenko.core.logger

import android.util.Log
import com.nikolaenko.core.BuildConfig

object Logger {

    fun d(message: String) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, message)
        }
    }

    fun v(message: String) {
        if (BuildConfig.DEBUG) {
            Log.v(TAG, message)
        }
    }

    fun w(message: String) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, message)
        }
    }

    fun d(t: Throwable) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, "", t)
        }
    }

    const val TAG = "PlaygroundTag"
}