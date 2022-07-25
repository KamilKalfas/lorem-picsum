package com.kkalfas.lorempicsum.discover.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kkalfas.lorempicsum.app.util.CoroutineDispatchers
import com.kkalfas.lorempicsum.core.domain.LCE
import com.kkalfas.lorempicsum.discover.domain.GetBrowseAllFeedUseCase
import com.kkalfas.lorempicsum.discover.domain.GetWhatsNewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val dispatchers: CoroutineDispatchers,
    private val getWhatsNewUseCase: GetWhatsNewUseCase,
    private val getBrowseAllFeedUseCase: GetBrowseAllFeedUseCase
) : ViewModel() {

    val uiState = MutableStateFlow(
        DiscoveryUiState(
            isLoading = true,
            whatsNewFeed = emptyList()
        )
    )

    fun onGetWhatsNewFeed() {
        getWhatsNewUseCase().onEach {
            when (it) {
                is LCE.Error -> {
                    uiState.value = uiState.value.copy(
                        isLoading = false,
                        errors = it.failure
                    )
                }
                LCE.Loading -> uiState.value = uiState.value.copy(isLoading = true)
                is LCE.Success -> {
                    uiState.value = uiState.value.copy(
                        isLoading = false,
                        whatsNewFeed = it.data
                    )
                }
            }
        }.launchIn(viewModelScope + dispatchers.io)
    }

    fun onGetBrowseAllFeed() {
        getBrowseAllFeedUseCase().onEach {
            when (it) {
                is LCE.Error -> {
                    uiState.value = uiState.value.copy(
                        isLoading = false,
                        errors = it.failure
                    )
                }
                LCE.Loading -> uiState.value = uiState.value.copy(isLoading = true)
                is LCE.Success -> {
                    uiState.value = uiState.value.copy(
                        isLoading = false,
                        browseAllFeed = it.data
                    )
                }
            }
        }.launchIn(viewModelScope + dispatchers.io)
    }
}
