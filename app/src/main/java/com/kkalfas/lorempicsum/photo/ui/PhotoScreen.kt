package com.kkalfas.lorempicsum.photo.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.app.util.TimberAdapter
import com.kkalfas.lorempicsum.common.domain.model.Photo
import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo
import com.kkalfas.lorempicsum.common.ui.components.ShowLoadingSpinner
import com.kkalfas.lorempicsum.theme.ui.Theme

@Composable
fun PhotoScreen(
    modifier: Modifier = Modifier,
    photo: PhotoCardInfo,
    onBackClick: () -> Unit
) {
    BackHandler {
        onBackClick()
    }
    PhotoContent(
        modifier = modifier,
        photo = photo,
        onBackClick = onBackClick
    )
}

@Composable
private fun PhotoContent(
    modifier: Modifier = Modifier,
    photo: PhotoCardInfo,
    onBackClick: () -> Unit
) {
    val config = LocalConfiguration.current
    val urlWidthHeight = photo.photo.urlWidthHeight(config.screenWidthDp, config.screenHeightDp)
    TimberAdapter.log("PhotoScreen photoUrl = $urlWidthHeight")
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Theme.colors.uiBackground)
    ) {
        SubcomposeAsyncImage(
            modifier = modifier
                .fillMaxSize()
                .align(Alignment.Center),
            model = urlWidthHeight,
            loading = {
                ShowLoadingSpinner()
            },
            contentDescription = null
        )
        Toolbar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart),
            photo = photo,
            onBackClick = onBackClick
        )
    }
}

@Composable
private fun Toolbar(
    modifier: Modifier = Modifier,
    photo: PhotoCardInfo,
    onBackClick: () -> Unit
) = Box(
    modifier = modifier
        .height(56.dp)
        .fillMaxWidth()
        .drawWithContent {
            drawRect(
                brush = Brush.horizontalGradient(listOf(Color.White, Color.Black)),
                alpha = 0.5f
            )
            drawContent()
        }
        .padding(horizontal = 16.dp, vertical = 8.dp),
    contentAlignment = Alignment.TopStart
) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .align(Alignment.TopStart),
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = rememberImagePainter(
                data = photo.avatarUrl,
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
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(text = photo.name, color = Theme.colors.textPrimary)
            Text(text = photo.username, color = Theme.colors.textHelp)
        }
    }
    IconButton(
        modifier = Modifier
            .size(24.dp)
            .align(Alignment.CenterEnd),
        onClick = onBackClick,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = null,
            tint = Theme.colors.iconActive
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewPhotoScreen() {
    val photo = PhotoCardInfo(
        photo = Photo("https://picsum.photos/id/234/"),
        avatarUrl = "https://i.pravatar.cc/150?u=7",
        name = "First Lastname",
        username = "@username"
    )
    PhotoContent(
        photo = photo,
        onBackClick = {}
    )
}
