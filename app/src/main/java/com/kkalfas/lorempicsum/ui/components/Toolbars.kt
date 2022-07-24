package com.kkalfas.lorempicsum.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.kkalfas.lorempicsum.theme.ui.Theme

private const val defaultToolbarSize = 112

@Composable
fun CollapsingToolbar(
    modifier: Modifier = Modifier,
    collapsedHeight: Dp = 56.dp,
    expandedHeight: Dp = 112.dp,
    scrollState: ScrollState,
    bottomBorderVisible: Boolean = true,
    content: @Composable () -> Unit
) {
    val height by animateDpAsState(
        targetValue = max(
            collapsedHeight,
            expandedHeight - (scrollState.value * 0.1f).dp
        )
    )
    Column(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .height(height)
            .padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = { content() }
    )
    if (bottomBorderVisible) Divider(
        modifier = Modifier.fillMaxWidth(),
        color = Theme.colors.uiBorder
    )
}

@Composable
fun AppToolbar(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .height(defaultToolbarSize.dp)
            .padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = { content() }
    )
}
