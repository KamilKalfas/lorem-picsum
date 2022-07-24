package com.kkalfas.lorempicsum.login.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : ViewModel() {

    var uiState = MutableStateFlow(
        LoginUiState(
            isLoading = false
        )
    )
        private set
}
