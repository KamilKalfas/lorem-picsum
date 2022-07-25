package com.kkalfas.lorempicsum.photo.domain

import com.kkalfas.lorempicsum.photo.domain.model.PhotoDto

interface PhotoRepository {
    suspend fun getWhatsNew(): List<PhotoDto>
    suspend fun getBrowseAll(): List<PhotoDto>
}
