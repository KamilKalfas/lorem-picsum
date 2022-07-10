package com.kkalfas.lorempicsum.welcome.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.common.ui.components.buttons.PrimaryButton
import com.kkalfas.lorempicsum.common.ui.components.buttons.SecondaryButton
import com.kkalfas.lorempicsum.theme.ui.Theme

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onSignupClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    WelcomeContent(
        onSignupClick = onSignupClick,
        onLoginClick = onLoginClick
    )
}

@Composable
private fun WelcomeContent(
    modifier: Modifier = Modifier,
    onSignupClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize(1f)
            .background(Theme.colors.uiBackground)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.9f),
            painter = rememberImagePainter(
                request = ImageRequest.Builder(LocalContext.current)
                    .placeholder(R.drawable.welcome_bg)
                    .data(R.drawable.welcome_bg)
                    .build()
            ),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .fillMaxHeight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            PrimaryButton(
                modifier = Modifier.fillMaxWidth(.5f),
                onClick = onSignupClick,
                labelId = R.string.signup_button_label
            )
            Spacer(modifier = Modifier.width(8.dp))
            SecondaryButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onLoginClick,
                labelId = R.string.login_button_label
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    WelcomeContent(
        onLoginClick = {},
        onSignupClick = {}
    )
}
