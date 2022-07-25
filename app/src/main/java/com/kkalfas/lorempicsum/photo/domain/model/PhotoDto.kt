package com.kkalfas.lorempicsum.photo.domain.model

import com.kkalfas.lorempicsum.photo.data.model.ImageDetailsResponse

data class PhotoDto(
    val id: Int,
    val baseUrl: String
)

fun ImageDetailsResponse.toDto() = PhotoDto(id, url)
