package com.kkalfas.lorempicsum.core

interface LoggerAdapter {
    fun log(message: String) = Unit
    fun log(exception: Exception) = Unit
    fun log(message: String, throwable: Throwable) = Unit
}
