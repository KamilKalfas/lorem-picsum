package com.kkalfas.lorempicsum.profile.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerializedName(value = "id") val id: Int,
    @SerializedName(value = "name") val name: String,
    @SerializedName(value = "email") val email: String
)
