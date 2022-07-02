package com.kkalfas.lorempicsum.discover.ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.kkalfas.lorempicsum.theme.ui.Theme

@Composable
fun DiscoverScreen(
    modifier: Modifier = Modifier
) {
    val state = DiscoveryUiState(
        isLoading = false,
        whatsNewFeed = IntRange(0, 19).map { i ->
            PhotoCardInfo(
                imageUrl = "https://picsum.photos/id/${i + 10}/536/354",
                avatarUrl = "https://i.pravatar.cc/150?u=$i",
                name = "First Lastname",
                username = "@username"
            )
        }
    )
    DiscoverContent(
        modifier = modifier,
        uiState = state
    )
}

data class DiscoveryUiState(
    val isLoading: Boolean = true,
    val errors: String? = null,
    val whatsNewFeed: List<PhotoCardInfo> = emptyList()
)

@Composable
private fun DiscoverContent(
    modifier: Modifier,
    uiState: DiscoveryUiState
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Theme.colors.uiBackground)
    ) {
        val scrollState = rememberScrollState()

        DiscoverToolbar(scrollState)

        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState, enabled = true)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            uiState.whatsNewFeed.forEach {
                PhotoCard(
                    cardInfo = it
                )
            }
        }

    }
}

@Composable
private fun DiscoverToolbar(scrollState: ScrollState) {
    CollapsingToolbar(
        scrollState = scrollState
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(2.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Toolbar Title", color = Theme.colors.textPrimary)
        }
    }
}

@Composable
private fun CollapsingToolbar(
    modifier: Modifier = Modifier,
    collapsedHeight: Dp = 56.dp,
    expandedHeight: Dp = 112.dp,
    scrollState: ScrollState,
    content: @Composable () -> Unit
) {
    val height by animateDpAsState(targetValue = max(collapsedHeight, expandedHeight -(scrollState.value * 0.1f).dp))
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = { content() }
    )
    Divider(modifier = Modifier.fillMaxWidth(), color = Theme.colors.uiBorder)
}

data class PhotoCardInfo(
    val imageUrl: String,
    val avatarUrl: String,
    val name: String,
    val username: String
)

private val photoCardSize = 343.dp

@Composable
fun PhotoCard(
    modifier: Modifier = Modifier,
    cardInfo: PhotoCardInfo
) {
    Card(
        modifier = modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
        ) {
            Image(
                modifier = Modifier.size(photoCardSize),
                contentScale = ContentScale.FillHeight,
                painter = rememberImagePainter(
                    data = cardInfo.imageUrl,
                    builder = {
                        crossfade(true)
                    },
                ),
                contentDescription = null
            )
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = cardInfo.avatarUrl,
                        builder = {
                            crossfade(true)
                            scale(Scale.FIT)
                            transformations(CircleCropTransformation())
                        },
                    ),
                    contentDescription = null
                )
                Spacer(Modifier.width(8.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = cardInfo.name, color = Theme.colors.textPrimary)
                    Text(text = cardInfo.username, color = Theme.colors.textHelp)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewDiscover() {
    val state = DiscoveryUiState(
        isLoading = false,
        whatsNewFeed = IntRange(0, 19).map { i ->
            PhotoCardInfo(
                imageUrl = "https://picsum.photos/id/${i + 10}/536/354",
                avatarUrl = "https://i.pravatar.cc/150?u=$i",
                name = "First Lastname",
                username = "@username"
            )
        }
    )
    DiscoverContent(
        modifier = Modifier,
        uiState = state
    )
}

@Preview
@Composable
private fun PreviewPhotoCard() {
    val cardInfo = PhotoCardInfo(
        imageUrl = "https://picsum.photos/343/343",
        avatarUrl = "https://i.pravatar.cc/150?u=2",
        name = "First Lastname",
        username = "@username"
    )
    Column(Modifier.wrapContentSize()) {
        PhotoCard(
            cardInfo = cardInfo
        )
    }
}
