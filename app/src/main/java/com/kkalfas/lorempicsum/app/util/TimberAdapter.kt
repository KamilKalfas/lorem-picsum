package com.kkalfas.lorempicsum.app.util

import com.kkalfas.lorempicsum.core.LoggerAdapter
import timber.log.Timber

object TimberAdapter : LoggerAdapter {
    private const val TAG = "APP_LOGGER"

    init {
        Timber.plant(Timber.DebugTree())
    }

    override fun log(message: String) = Timber.tag(TAG).d(message)
    override fun log(exception: Exception) = Timber.tag(TAG).d(exception)
    override fun log(message: String, throwable: Throwable) = Timber.tag(TAG).d(t = throwable, message = message)
}
