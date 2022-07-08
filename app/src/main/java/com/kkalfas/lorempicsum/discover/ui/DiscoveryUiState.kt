package com.kkalfas.lorempicsum.discover.ui

import com.kkalfas.lorempicsum.ui.components.PhotoCardInfo

data class DiscoveryUiState(
    val isLoading: Boolean = true,
    val errors: String? = null,
    val whatsNewFeed: List<PhotoCardInfo> = emptyList()
)