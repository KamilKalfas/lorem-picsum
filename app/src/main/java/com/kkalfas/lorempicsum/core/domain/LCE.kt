package com.kkalfas.lorempicsum.core.domain

import com.kkalfas.lorempicsum.core.LoggerAdapter
import com.kkalfas.lorempicsum.network.domain.NetworkHandler

sealed class LCE<out R> {

    data class Success<out T>(val data: T) : LCE<T>()
    data class Error(val failure: Failure) : LCE<Nothing>()
    object Loading : LCE<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$failure]"
            Loading -> "Loading"
        }
    }

    class Executor constructor(
        val networkHandler: NetworkHandler,
        val loggerAdapter: LoggerAdapter
    ) {
        inline fun <reified T : Any> execute(block: () -> T): LCE<T> {
            return when (networkHandler.isNetworkAvailable()) {
                true -> {
                    try {
                        Success(block())
                    } catch (e: Exception) {
                        loggerAdapter.log("Executor#execute: ${e::class.java.simpleName}")
                        Error(e.toCustomExceptions())
                    }
                }
                else -> Error(Failure.NetworkConnection)
            }
        }
    }
}

sealed class Failure {
    object NetworkConnection : Failure()
    data class ServerFailure(val e: Exception) : Failure()
    data class HttpError(val statusCode: Int, val e: Exception) : Failure()
    data class GenericError(val e: Exception) : Failure()

    override fun toString(): String = this.javaClass.simpleName
}

fun Exception.toCustomExceptions(): Failure = when (this) {
    else -> Failure.GenericError(this)
}
