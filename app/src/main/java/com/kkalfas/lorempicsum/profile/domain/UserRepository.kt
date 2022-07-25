package com.kkalfas.lorempicsum.profile.domain

import com.kkalfas.lorempicsum.network.domain.UserDto

interface UserRepository {
    suspend fun getUser(userId: Int): UserDto
}
