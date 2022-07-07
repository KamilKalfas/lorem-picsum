package com.kkalfas.lorempicsum.discover.ui

import androidx.lifecycle.ViewModel
import com.kkalfas.lorempicsum.ui.components.Photo
import com.kkalfas.lorempicsum.ui.components.PhotoCardInfo
import kotlinx.coroutines.flow.MutableStateFlow

class DiscoverViewModel : ViewModel() {

    val uiState = MutableStateFlow(
        DiscoveryUiState(
            isLoading = true,
            whatsNewFeed = emptyList()
        )
    )

    fun onGetWhatsNewFeed() {
        uiState.value = uiState.value.copy(
            isLoading = false,
            whatsNewFeed = feed
        )
    }

    private val feed = IntRange(0, 19).map { i ->
        PhotoCardInfo(
            photo = Photo("https://picsum.photos/id/${i + 10}"),
            avatarUrl = "https://i.pravatar.cc/150?u=$i",
            name = "First Lastname",
            username = "@username"
        )
    }
}
