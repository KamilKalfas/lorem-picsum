package com.kkalfas.lorempicsum.common.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoCardInfo(
    val photo: Photo,
    val avatarUrl: String,
    val name: String,
    val username: String
) : Parcelable

@Parcelize
data class Photo(
    val baseUrl: String,
) : Parcelable {
    fun urlWidthHeight(width: Int, height: Int) = "$baseUrl/$width/$height"
    fun urlSize(size: Int) = "$baseUrl/$size"
}
