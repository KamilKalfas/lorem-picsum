package com.kkalfas.lorempicsum.photo.domain

import com.kkalfas.lorempicsum.photo.data.model.ImageDetailsResponse

interface PhotoService {
    val baseUrl: String

    suspend fun getWhatsNew(): List<ImageDetailsResponse>
    suspend fun getBrowseAll(): List<ImageDetailsResponse>
}
