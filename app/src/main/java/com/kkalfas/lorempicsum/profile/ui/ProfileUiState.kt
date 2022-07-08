package com.kkalfas.lorempicsum.profile.ui

import com.kkalfas.lorempicsum.profile.domain.model.ProfileInfo

data class ProfileUiState(
    val isLoading: Boolean = true,
    val errors: String? = null,
    val profile: ProfileInfo? = null
)
