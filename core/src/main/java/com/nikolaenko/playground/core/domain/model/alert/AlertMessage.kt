package com.nikolaenko.playground.core.domain.model.alert

data class AlertMessage(
    val message: String,
    val type: Type
) {

    enum class Type {
        ERROR, SUCCESS
    }
}