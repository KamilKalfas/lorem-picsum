package com.kkalfas.lorempicsum.profile.domain.model

import com.kkalfas.lorempicsum.profile.data.model.UserResponse

data class UserDto(
    val id: Int,
    val name: String,
    val email: String
) {
    val avatarUrl = "https://i.pravatar.cc/150?u=$id"
}

fun UserResponse.toDto() = UserDto(id, name, email)
