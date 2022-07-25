package com.kkalfas.lorempicsum.discover.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.common.domain.model.Photo
import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo
import com.kkalfas.lorempicsum.common.ui.components.ShowLoadingSpinner
import com.kkalfas.lorempicsum.theme.ui.Theme
import com.kkalfas.lorempicsum.ui.components.CollapsingToolbar
import com.kkalfas.lorempicsum.ui.components.HorizontalSection
import com.kkalfas.lorempicsum.ui.components.PhotoCard
import com.kkalfas.lorempicsum.ui.components.VerticalGrid

@Composable
fun DiscoverScreen(
    modifier: Modifier = Modifier,
    viewModel: DiscoverViewModel,
    onPhotoItemClicked: (PhotoCardInfo) -> Unit
) {

    // TODO remove after navigation compose migration
    val activity = (LocalContext.current as? Activity)
    BackHandler {
        activity?.let {
            it.finish()
        }
    }

    DiscoverContent(
        modifier = modifier,
        uiState = viewModel.uiState.collectAsState().value,
        onPhotoItemClicked = onPhotoItemClicked
    )
}

@Composable
private fun DiscoverContent(
    modifier: Modifier,
    uiState: DiscoveryUiState,
    onPhotoItemClicked: (PhotoCardInfo) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Theme.colors.uiBackground)
    ) {
        val feedScrollState = rememberScrollState()
        val whatsNewScrollState = rememberScrollState()
        Toolbar(feedScrollState)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(feedScrollState)
        ) {
            WhatsNewSection(
                scrollState = whatsNewScrollState,
                whatsNewFeed = uiState.whatsNewFeed,
                onPhotoItemClicked = onPhotoItemClicked
            )
            Spacer(modifier = Modifier.height(16.dp))
            BrowsAllSection(
                isLoading = uiState.isLoading,
                browseAllFeed = uiState.browseAllFeed,
                onPhotoItemClicked = onPhotoItemClicked
            )
        }
    }
}

@Composable
private fun Toolbar(scrollState: ScrollState) {
    CollapsingToolbar(
        scrollState = scrollState
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
                text = stringResource(id = R.string.discover_title),
                color = Theme.colors.textPrimary,
                style = Theme.typography.title
            )
        }
    }
}

@Composable
private fun BrowsAllSection(
    isLoading: Boolean,
    browseAllFeed: List<PhotoCardInfo>,
    onPhotoItemClicked: (PhotoCardInfo) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = stringResource(id = R.string.discover_browse_all_label),
            color = Theme.colors.textPrimary,
            style = Theme.typography.contentHeader
        )
        Spacer(
            modifier = Modifier
                .width(8.dp)
                .height(8.dp)
        )
        if (browseAllFeed.isEmpty()) {
            if (isLoading) CircularProgressIndicator(color = Theme.colors.iconActive)
        } else {
            VerticalGrid(
                items = browseAllFeed.map { card ->
                    { _, _ ->
                        val width = 167
                        val height = 310
                        SubcomposeAsyncImage(
                            modifier = Modifier
                                .background(Theme.colors.uiBorder)
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { onPhotoItemClicked(card) },
                            contentScale = ContentScale.FillHeight,
                            model = card.photo.urlWidthHeight(width, height),
                            loading = {
                                ShowLoadingSpinner()
                            },
                            contentDescription = null
                        )
                    }
                }
            )
        }
    }
}

@Composable
private fun WhatsNewSection(
    scrollState: ScrollState,
    whatsNewFeed: List<PhotoCardInfo>,
    onPhotoItemClicked: (PhotoCardInfo) -> Unit
) {
    HorizontalSection(
        scrollState = scrollState,
        headerLabel = R.string.discover_whats_new_label,
        feed = whatsNewFeed.map {
            {
                Spacer(modifier = Modifier.width(16.dp))
                PhotoCard(
                    cardInfo = it,
                    onClick = onPhotoItemClicked
                )
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewDiscover() {
    val state = DiscoveryUiState(
        isLoading = false,
        whatsNewFeed = IntRange(0, 19).map { i ->
            PhotoCardInfo(
                photo = Photo("https://picsum.photos/id/${i + 10}/536/354"),
                avatarUrl = "https://i.pravatar.cc/150?u=$i",
                name = "First Lastname",
                username = "@username"
            )
        }
    )
    DiscoverContent(
        modifier = Modifier,
        uiState = state,
        onPhotoItemClicked = {}
    )
}
