package com.kkalfas.lorempicsum.photo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.common.domain.model.Photo
import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo
import com.kkalfas.lorempicsum.theme.ui.Theme

@Composable
fun PhotoScreen(
    modifier: Modifier = Modifier,
    photo: PhotoCardInfo
) {
    PhotoContent(
        modifier = modifier,
        photo = photo
    )
}

@Composable
private fun PhotoContent(
    modifier: Modifier = Modifier,
    photo: PhotoCardInfo
) {
    val config = LocalConfiguration.current
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = modifier
                .fillMaxSize()
                .align(Alignment.Center),
            painter = rememberImagePainter(
                data = photo.photo.urlWidthHeight(config.screenWidthDp, config.screenHeightDp),
                builder = {
                    crossfade(true)
                    scale(Scale.FILL)
                },
                ),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )
        Toolbar(
            modifier = Modifier.align(Alignment.TopStart),
            photo = photo
        )
    }
}

@Composable
private fun Toolbar(
    modifier: Modifier = Modifier,
    photo: PhotoCardInfo
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .systemBarsPadding()
            .height(40.dp)
            .fillMaxWidth(),
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
        Icon(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterEnd),
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
        photo = photo
    )
}
