package com.kkalfas.lorempicsum.search.ui

import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo

data class SearchUiState(
    val isLoading: Boolean,
    val searchResult: List<PhotoCardInfo>
)
