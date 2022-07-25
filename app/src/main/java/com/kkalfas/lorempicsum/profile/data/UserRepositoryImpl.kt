package com.kkalfas.lorempicsum.profile.data

import com.kkalfas.lorempicsum.profile.domain.UserRepository
import com.kkalfas.lorempicsum.profile.domain.UserService
import com.kkalfas.lorempicsum.profile.domain.model.UserDto
import com.kkalfas.lorempicsum.profile.domain.model.toDto
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val service: UserService
) : UserRepository {

    override suspend fun getUser(userId: Int): UserDto {
        return requireNotNull(service.getUsers().map { it.toDto() }.find { it.id == userId })
    }
}
