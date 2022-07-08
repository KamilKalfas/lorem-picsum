package com.kkalfas.lorempicsum.profile.domain.model

import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo

data class ProfileInfo(
    val avatarUrl: String,
    val name: String,
    val location: String,
    val isFollowed: Boolean,
    val pictures: List<PhotoCardInfo> = emptyList()
)
