package com.kkalfas.lorempicsum.profile.domain

import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userId: Int) = repository.getUser(userId)
}
