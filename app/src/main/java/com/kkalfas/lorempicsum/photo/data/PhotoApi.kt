package com.kkalfas.lorempicsum.photo.data

import com.kkalfas.lorempicsum.photo.data.model.ImageDetailsResponse
import com.kkalfas.lorempicsum.photo.domain.PhotoService
import javax.inject.Inject

class PhotoApi @Inject constructor() : PhotoService {
    override val baseUrl: String
        get() = "https://picsum.photos"

    override suspend fun getWhatsNew(): List<ImageDetailsResponse> = IntRange(1, 10).map {
        ImageDetailsResponse(id = it, url = "$baseUrl/id/${1000 + it}")
    }

    override suspend fun getBrowseAll(): List<ImageDetailsResponse> = IntRange(1, 30).map {
        val id = (it % 10) + 1
        ImageDetailsResponse(id = id, url = "$baseUrl/id/${1010 + it}")
    }
}
