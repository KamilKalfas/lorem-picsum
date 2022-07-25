package com.kkalfas.lorempicsum.photo.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageDetailsResponse(
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "url") val url: String,
)
