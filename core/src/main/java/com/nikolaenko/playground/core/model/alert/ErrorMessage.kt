package com.nikolaenko.playground.core.model.alert

data class ErrorMessage(
    val message: String,
    val type: Type
) {

    enum class Type {
        ERROR, SUCCESS
    }
}