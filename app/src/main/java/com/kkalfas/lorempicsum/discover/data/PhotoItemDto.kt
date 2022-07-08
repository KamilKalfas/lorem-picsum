package com.kkalfas.lorempicsum.discover.data

import android.os.Parcelable
import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo
import kotlinx.parcelize.Parcelize

@Parcelize
@Deprecated("", replaceWith = ReplaceWith("PhotoCardInfo"))
data class PhotoItemDto(
    val name: String,
    val profileName: String,
    val profileImageUrl: String,
    val photoUrl: String
) : Parcelable

fun PhotoCardInfo.toLegacyDto() = PhotoItemDto(
    name = name,
    profileName = username,
    profileImageUrl = avatarUrl,
    photoUrl = photo.baseUrl
)
