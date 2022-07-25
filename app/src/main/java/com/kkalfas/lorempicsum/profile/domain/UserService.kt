package com.kkalfas.lorempicsum.profile.domain

import com.kkalfas.lorempicsum.profile.data.model.UserResponse

interface UserService {
    val baseUrl: String

    suspend fun getUsers(): List<UserResponse>
}
