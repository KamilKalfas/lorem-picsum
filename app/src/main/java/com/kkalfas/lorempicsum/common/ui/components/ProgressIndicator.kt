package com.kkalfas.lorempicsum.common.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun LoadingSpinner(
    modifier: Modifier,
    color: Color = Color.Black,
    strokeWidth: Dp = ProgressIndicatorDefaults.StrokeWidth
) {
    CircularProgressIndicator(modifier = modifier, color = color, strokeWidth = strokeWidth)
}

@Composable
fun ShowLoadingSpinner(
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {
        LoadingSpinner(Modifier.align(Alignment.Center))
    }
}
