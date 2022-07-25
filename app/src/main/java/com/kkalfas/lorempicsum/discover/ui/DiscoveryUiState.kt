package com.kkalfas.lorempicsum.discover.ui

import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo
import com.kkalfas.lorempicsum.core.domain.Failure

data class DiscoveryUiState(
    val isLoading: Boolean = true,
    val errors: Failure? = null,
    val whatsNewFeed: List<PhotoCardInfo> = emptyList(),
    val browseAllFeed: List<PhotoCardInfo> = emptyList()
)
