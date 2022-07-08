package com.kkalfas.lorempicsum.profile.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kkalfas.lorempicsum.common.domain.model.Photo
import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo
import com.kkalfas.lorempicsum.profile.domain.model.ProfileInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    val uiState = MutableStateFlow(
        ProfileUiState(
            isLoading = true
        )
    )

    fun onGetProfile() {
        viewModelScope.launch {
            delay(1000)
            uiState.value = uiState.value.copy(
                isLoading = false,
                profile = ProfileInfo(
                    name = "Jane",
                    avatarUrl = "https://i.pravatar.cc/150?u=7",
                    location = "San Francisco, CA",
                    isFollowed = false,
                    pictures = listOf(
                        PhotoCardInfo(
                            photo = Photo("https://picsum.photos/id/10"),
                            avatarUrl = "https://i.pravatar.cc/150?u=7",
                            name = "Jane",
                            username = "@Jane"
                        ),
                        PhotoCardInfo(
                            photo = Photo("https://picsum.photos/id/11"),
                            avatarUrl = "https://i.pravatar.cc/150?u=7",
                            name = "Jane",
                            username = "@Jane"
                        ),
                        PhotoCardInfo(
                            photo = Photo("https://picsum.photos/id/12"),
                            avatarUrl = "https://i.pravatar.cc/150?u=7",
                            name = "Jane",
                            username = "@Jane"
                        )
                    )
                )
            )
        }
    }
}
