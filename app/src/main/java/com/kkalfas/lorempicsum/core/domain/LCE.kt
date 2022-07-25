package com.kkalfas.lorempicsum.core.domain

import com.kkalfas.lorempicsum.core.LoggerAdapter
import com.kkalfas.lorempicsum.network.domain.NetworkHandler
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import javax.inject.Inject

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

    class Executor @Inject constructor(
        val networkHandler: NetworkHandler,
        val loggerAdapter: LoggerAdapter
    ) {
        @SuppressWarnings("TooGenericExceptionCaught")
        inline fun <reified T : Any> execute(block: () -> T): LCE<T> {
            return if (networkHandler.isNetworkAvailable()) {
                val result = try {
                    Success(block())
                } catch (e: Exception) {
                    loggerAdapter.log("Executor#execute: ${e.stackTraceToString()}")
                    Error(e.toCustomExceptions())
                }
                result
            } else Error(Failure.NetworkConnection)
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
    is ServerResponseException -> Failure.ServerFailure(this)
    is ClientRequestException -> Failure.HttpError(this.response.status.value, this)
    else -> Failure.GenericError(this)
}
