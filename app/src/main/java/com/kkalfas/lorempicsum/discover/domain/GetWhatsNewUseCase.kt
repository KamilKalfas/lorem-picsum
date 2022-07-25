package com.kkalfas.lorempicsum.discover.domain

import com.kkalfas.lorempicsum.common.domain.model.Photo
import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo
import com.kkalfas.lorempicsum.core.domain.LCE
import com.kkalfas.lorempicsum.photo.domain.PhotoRepository
import com.kkalfas.lorempicsum.profile.domain.GetUserUseCase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWhatsNewUseCase @Inject constructor(
    private val photoRepository: PhotoRepository,
    private val getUserUseCase: GetUserUseCase,
    private val executor: LCE.Executor
) {
    operator fun invoke() = flow {
        emit(LCE.Loading)
        val result = executor.execute {
            val result = photoRepository.getWhatsNew()
            result.map { photo ->
                val user = getUserUseCase(photo.id)
                PhotoCardInfo(
                    Photo(baseUrl = photo.baseUrl),
                    avatarUrl = user.avatarUrl,
                    name = user.name,
                    username = user.email
                )
            }
        }
        emit(result)
    }
}
