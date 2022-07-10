package com.kkalfas.lorempicsum.search.ui

import androidx.lifecycle.ViewModel
import com.kkalfas.lorempicsum.common.domain.model.Photo
import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo
import kotlinx.coroutines.flow.MutableStateFlow

class SearchViewModel : ViewModel() {

    val uiState = MutableStateFlow(
        SearchUiState(
            isLoading = false,
            searchResult = photoItemGenerator(18)
        )
    )
}

private fun photoItemGenerator(repeatTimes: Int = 10): List<PhotoCardInfo> {
    val list = mutableListOf<PhotoCardInfo>()
    repeat(repeatTimes) {
        list.add(
            PhotoCardInfo(
                photo = Photo("https://picsum.photos/id/${it + 10}"),
                avatarUrl = "https://i.pravatar.cc/150?u=$it",
                name = "First Lastname",
                username = "@username"
            )
        )
    }
    return list
}
