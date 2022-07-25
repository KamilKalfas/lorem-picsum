package com.kkalfas.lorempicsum.app.di

import com.kkalfas.lorempicsum.app.util.CoroutineDispatchers
import com.kkalfas.lorempicsum.app.util.TimberAdapter
import com.kkalfas.lorempicsum.core.LoggerAdapter
import com.kkalfas.lorempicsum.core.domain.LCE
import com.kkalfas.lorempicsum.network.domain.NetworkHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCoroutineDispatchers() = CoroutineDispatchers(
        io = Dispatchers.IO,
        computation = Dispatchers.Default,
        main = Dispatchers.Main
    )

    @Singleton
    @Provides
    fun provideLogger(): LoggerAdapter = TimberAdapter


    @Singleton
    @Provides
    fun provideExecutor(
        logger: LoggerAdapter,
        networkHandler: NetworkHandler
    ): LCE.Executor = LCE.Executor(
        networkHandler = networkHandler,
        loggerAdapter = logger,
    )
}
