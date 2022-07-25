package com.kkalfas.lorempicsum.profile.data

import com.kkalfas.lorempicsum.network.domain.KtorClientAdapter
import com.kkalfas.lorempicsum.profile.data.model.UserResponse
import com.kkalfas.lorempicsum.profile.domain.UserService
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import javax.inject.Inject

class UserApi @Inject constructor(
    private val ktorClientAdapter: KtorClientAdapter
) : UserService {
    override val baseUrl: String
        get() = "http://jsonplaceholder.typicode.com"

    override suspend fun getUsers(): List<UserResponse> = ktorClientAdapter.client.get {
        url("$baseUrl/users")
    }.body()
}
