package com.kkalfas.lorempicsum.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.kkalfas.lorempicsum.common.domain.model.Photo
import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo
import com.kkalfas.lorempicsum.theme.ui.Theme

private const val photoCardSize = 343

@Composable
fun PhotoCard(
    modifier: Modifier = Modifier,
    cardInfo: PhotoCardInfo,
    onClick: (PhotoCardInfo) -> Unit
) {
    Card(
        modifier = modifier.clickable { onClick(cardInfo) },
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
        ) {
            Image(
                modifier = Modifier.size(photoCardSize.dp),
                contentScale = ContentScale.FillHeight,
                painter = rememberImagePainter(
                    data = cardInfo.photo.urlSize(photoCardSize),
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

@Preview
@Composable
private fun PreviewPhotoCard() {
    val cardInfo = PhotoCardInfo(
        photo = Photo("https://picsum.photos/343/343"),
        avatarUrl = "https://i.pravatar.cc/150?u=2",
        name = "First Lastname",
        username = "@username"
    )
    Column(Modifier.wrapContentSize()) {
        PhotoCard(
            cardInfo = cardInfo,
            onClick = {}
        )
    }
}
