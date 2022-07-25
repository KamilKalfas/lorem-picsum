package com.kkalfas.lorempicsum.photo.data

import com.kkalfas.lorempicsum.photo.domain.PhotoRepository
import com.kkalfas.lorempicsum.photo.domain.PhotoService
import com.kkalfas.lorempicsum.photo.domain.model.PhotoDto
import com.kkalfas.lorempicsum.photo.domain.model.toDto
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val service: PhotoService
) : PhotoRepository {

    override suspend fun getWhatsNew(): List<PhotoDto> =
        service.getWhatsNew().map { it.toDto() }

    override suspend fun getBrowseAll(): List<PhotoDto> =
        service.getBrowseAll().map { it.toDto() }
}
