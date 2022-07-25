package com.kkalfas.lorempicsum.network.domain

import com.kkalfas.lorempicsum.BuildConfig
import com.kkalfas.lorempicsum.app.util.TimberAdapter
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Abstraction layer allowing to change [HttpClient] implementation
 */
interface KtorClientAdapter {
    val client: HttpClient

    class Impl(
        private val httpClientEngine: HttpClientEngine,
    ) : KtorClientAdapter {
        override val client: HttpClient by lazy {
            HttpClient(httpClientEngine) {
                installDefaultHeaders()

                install(UserAgent) { agent = "ktor" }

                if (BuildConfig.DEBUG) {
                    install(Logging) {
                        logger = object : Logger {
                            override fun log(message: String) {
                                TimberAdapter.log(message)
                            }
                        }
                        level = LogLevel.BODY
                    }
                }

                installJSONSerialization()
            }
        }
    }
}

fun HttpClientConfig<*>.installJSONSerialization() {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            }
        )
    }
}

fun HttpClientConfig<*>.installDefaultHeaders() {
    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
}
