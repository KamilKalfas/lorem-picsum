package com.kkalfas.lorempicsum.theme.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import com.google.accompanist.systemuicontroller.rememberSystemUiController

typealias Theme = LoremPicsumTheme

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkColorPalette() else lightColorPalette()

    val sysUiController = rememberSystemUiController()
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = colors.transparent,
            darkIcons = darkTheme,
            isNavigationBarContrastEnforced = false
        )
        sysUiController.setNavigationBarColor(
            color = colors.transparent,
            darkIcons = darkTheme,
            navigationBarContrastEnforced = false
        )
    }

    ProvideLoremPicsumTheme(
        colors = colors,
        type = LoremPicsumTheme.typography,
        content = content
    )
}

@Composable
fun ProvideLoremPicsumTheme(
    colors: LoremPicsumColors,
    type: LoremPicusmTypography,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    val typography = remember {
        type.copy()
    }
    colorPalette.update(colors)
    typography.update(type)
    CompositionLocalProvider(
        values = arrayOf(
            LocalLoremPicsumColors provides colorPalette,
            LocalLoremPicsumType provides typography
        ),
        content = content
    )
}

object LoremPicsumTheme {
    val colors: LoremPicsumColors
        @Composable
        get() = LocalLoremPicsumColors.current
    val typography
        @Composable
        get() = LocalLoremPicsumType.current
    val shapes
        @Composable
        get() = MaterialTheme.shapes
}
