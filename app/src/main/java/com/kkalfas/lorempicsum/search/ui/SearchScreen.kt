package com.kkalfas.lorempicsum.search.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo
import com.kkalfas.lorempicsum.common.ui.components.buttons.SecondaryButton
import com.kkalfas.lorempicsum.theme.ui.Theme
import com.kkalfas.lorempicsum.ui.components.CollapsingToolbar
import com.kkalfas.lorempicsum.ui.components.VerticalGrid

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel,
    onPhotoItemClicked: (PhotoCardInfo) -> Unit,
    onSeeMoreClicked: () -> Unit
) {
    SearchContent(
        uiState = viewModel.uiState.collectAsState().value,
        onPhotoItemClicked = onPhotoItemClicked,
        onSeeMoreClicked = onSeeMoreClicked
    )
}

@Composable
private fun SearchContent(
    modifier: Modifier = Modifier,
    uiState: SearchUiState,
    onPhotoItemClicked: (PhotoCardInfo) -> Unit,
    onSeeMoreClicked: () -> Unit
) {
    val scrollState = rememberScrollState()
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Theme.colors.uiBackground)
    ) {
        Toolbar(scrollState = scrollState)
        SearchBar(
            searchText = searchText,
            updateSearchText = {
                searchText = it
            },
            searchTextLabelId = R.string.search_hint
        )
        SearchResultContainer(
            scrollState = scrollState,
            isLoading = uiState.isLoading,
            searchResult = uiState.searchResult,
            onPhotoItemClicked = onPhotoItemClicked,
            onSeeMoreClicked = onSeeMoreClicked
        )
    }
}

@Composable
private fun SearchResultContainer(
    scrollState: ScrollState,
    isLoading: Boolean,
    searchResult: List<PhotoCardInfo>,
    onPhotoItemClicked: (PhotoCardInfo) -> Unit,
    onSeeMoreClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .padding(top = 16.dp, bottom = 16.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = stringResource(id = R.string.search_all_result_label).uppercase(),
            color = Theme.colors.textPrimary,
            style = Theme.typography.contentHeader
        )
        Spacer(
            modifier = Modifier
                .width(8.dp)
                .height(8.dp)
        )
        if (searchResult.isEmpty()) {
            if (isLoading) CircularProgressIndicator(color = Theme.colors.iconActive)
        } else {
            VerticalGrid(
                columns = 3,
                items = searchResult.map { card ->
                    { _, _ ->
                        val size = 107
                        Image(
                            modifier = Modifier
                                .size(size.dp)
                                .clickable { onPhotoItemClicked(card) },
                            contentScale = ContentScale.FillHeight,
                            painter = rememberImagePainter(
                                data = card.photo.urlSize(size),
                                builder = {
                                    crossfade(true)
                                },
                            ),
                            contentDescription = null
                        )
                    }
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        SecondaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = onSeeMoreClicked,
            labelId = R.string.search_see_more_button
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
private fun Toolbar(scrollState: ScrollState) {
    CollapsingToolbar(
        scrollState = scrollState,
        bottomBorderVisible = false
    ) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = stringResource(id = R.string.search_title),
                color = Theme.colors.textPrimary,
                style = Theme.typography.title
            )
        }
    }
}

@Composable
private fun SearchBar(
    modifier: Modifier = Modifier,
    searchText: TextFieldValue,
    @StringRes searchTextLabelId: Int,
    updateSearchText: (searchText: TextFieldValue) -> Unit
) {
    val inputUnFocusedColors = TextFieldDefaults.outlinedTextFieldColors(
        unfocusedBorderColor = Color.Transparent,
        errorBorderColor = Color.Transparent,
        backgroundColor = Theme.colors.uiBackground,
        textColor = Theme.colors.textHelp,
        placeholderColor = Theme.colors.textHelp,
    )
    val inputFocusedColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.Transparent,
        errorBorderColor = Color.Transparent,
        backgroundColor = Theme.colors.uiBackground,
        textColor = Theme.colors.textPrimary
    )

    var colors by remember { mutableStateOf(inputUnFocusedColors) }
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged {
                colors = if (it.hasFocus) inputFocusedColors
                else inputUnFocusedColors
            }
            .padding(horizontal = 16.dp)
            .height(52.dp)
            .border(1.dp, Theme.colors.textPrimary),
        value = searchText,
        onValueChange = updateSearchText,
        placeholder = {
            Text(text = stringResource(id = searchTextLabelId))
        },
        colors = colors,
        singleLine = true
    )
    Spacer(modifier = Modifier.height(32.dp))
}

@Preview
@Composable
private fun SearchScreenPreview() {
    val uiState = SearchUiState(
        isLoading = false,
        searchResult = emptyList()
    )
    SearchContent(
        uiState = uiState,
        onPhotoItemClicked = {},
        onSeeMoreClicked = {}
    )
}
