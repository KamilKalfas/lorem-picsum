package com.kkalfas.lorempicsum.profile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.common.domain.model.Photo
import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo
import com.kkalfas.lorempicsum.common.ui.components.buttons.PrimaryButton
import com.kkalfas.lorempicsum.common.ui.components.buttons.SecondaryButton
import com.kkalfas.lorempicsum.profile.domain.model.ProfileInfo
import com.kkalfas.lorempicsum.theme.ui.Theme
import com.kkalfas.lorempicsum.ui.components.VerticalGrid

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    onPhotoItemClicked: (PhotoCardInfo) -> Unit
) {
    ProfileContent(
        uiState = viewModel.uiState.collectAsState().value,
        onFollowButtonClick = {},
        onMessageButtonClick = {},
        onPhotoItemClicked = onPhotoItemClicked
    )
}

@Composable
private fun ProfileContent(
    modifier: Modifier = Modifier,
    uiState: ProfileUiState,
    onFollowButtonClick: (Boolean) -> Unit,
    onMessageButtonClick: () -> Unit,
    onPhotoItemClicked: (PhotoCardInfo) -> Unit
) {
    Column(
        modifier = modifier
            .background(Theme.colors.uiBackground)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Toolbar(
            isLoading = uiState.isLoading,
            profileInfo = uiState.profile,
            onFollowButtonClick = onFollowButtonClick,
            onMessageButtonClick = onMessageButtonClick
        )
        ProfileGallery(
            isLoading = uiState.isLoading,
            photos = uiState.profile?.pictures ?: emptyList(),
            onPhotoItemClicked = onPhotoItemClicked
        )
        Spacer(modifier = Modifier.height(76.dp))
    }
}

@Composable
private fun Toolbar(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    profileInfo: ProfileInfo?,
    onFollowButtonClick: (Boolean) -> Unit,
    onMessageButtonClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) Unit // TODO add loading
        else if (!isLoading && profileInfo != null) {
            Image(
                modifier = Modifier
                    .border(2.dp, Theme.colors.uiBorder, CircleShape)
                    .size(128.dp),
                painter = rememberImagePainter(
                    data = profileInfo.avatarUrl,
                    builder = {

                        transformations(CircleCropTransformation())
                    },
                ),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = profileInfo.name, style = Theme.typography.title)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = profileInfo.location, style = Theme.typography.contentHeader)
            Spacer(modifier = Modifier.height(32.dp))
            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = { onFollowButtonClick(profileInfo.isFollowed) },
                label = stringResource(id = R.string.profile_follow_button_label, profileInfo.name)
            )
            Spacer(modifier = Modifier.height(16.dp))
            SecondaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = onMessageButtonClick,
                labelId = R.string.profile_message_button_label
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun ProfileGallery(
    isLoading: Boolean,
    photos: List<PhotoCardInfo>,
    onPhotoItemClicked: (PhotoCardInfo) -> Unit
) {
    if (!isLoading)
        if (photos.isEmpty()) Unit // TODO NO PHOTOS COMPONENT
        else {
            VerticalGrid(
                items = photos.map { card ->
                    { _, _ ->
                        val width = 167
                        val height = 310
                        Image(
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { onPhotoItemClicked(card) },
                            contentScale = ContentScale.FillHeight,
                            painter = rememberImagePainter(
                                data = card.photo.urlWidthHeight(width, height),
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
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewProfileScreen() {
    val uiState = ProfileUiState(
        isLoading = false,
        profile = ProfileInfo(
            name = "Jane",
            avatarUrl = "https://i.pravatar.cc/150?u=7",
            location = "San Francisco, CA",
            isFollowed = false,
            pictures = listOf(
                PhotoCardInfo(
                    photo = Photo("https://picsum.photos/id/10"),
                    avatarUrl = "https://i.pravatar.cc/150?u=7",
                    name = "Jane",
                    username = "@Jane"
                ),
                PhotoCardInfo(
                    photo = Photo("https://picsum.photos/id/11"),
                    avatarUrl = "https://i.pravatar.cc/150?u=7",
                    name = "Jane",
                    username = "@Jane"
                ),
                PhotoCardInfo(
                    photo = Photo("https://picsum.photos/id/12"),
                    avatarUrl = "https://i.pravatar.cc/150?u=7",
                    name = "Jane",
                    username = "@Jane"
                )
            )
        )
    )
    ProfileContent(
        uiState = uiState,
        onFollowButtonClick = {},
        onMessageButtonClick = {},
        onPhotoItemClicked = {}
    )
}
