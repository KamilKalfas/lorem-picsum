package com.kkalfas.lorempicsum.common.domain.model

data class PhotoCardInfo(
    val photo: Photo,
    val avatarUrl: String,
    val name: String,
    val username: String
)

data class Photo(
    val baseUrl: String,
) {
    fun urlWidthHeight(width: Int, height: Int) = "$baseUrl/$width/$height"
    fun urlSize(size: Int) = "$baseUrl/$size"
}
