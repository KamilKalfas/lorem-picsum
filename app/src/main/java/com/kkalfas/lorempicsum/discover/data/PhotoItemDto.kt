package com.kkalfas.lorempicsum.discover.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoItemDto(
    val name: String,
    val profileName: String,
    val profileImageUrl: String,
    val photoUrl: String
) : Parcelable
