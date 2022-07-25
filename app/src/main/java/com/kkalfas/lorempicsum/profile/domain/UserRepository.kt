package com.kkalfas.lorempicsum.profile.domain

import com.kkalfas.lorempicsum.profile.domain.model.UserDto

interface UserRepository {
    suspend fun getUser(userId: Int): UserDto
}
