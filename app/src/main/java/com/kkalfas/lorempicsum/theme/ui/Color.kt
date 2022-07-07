package com.kkalfas.lorempicsum.theme.ui

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

fun lightColorPalette() = LoremPicsumColors(
    brand = Color.White,
    brandSecondary = Color.Black,
    brandGradient = listOf(Color.White, Color.LightGray, Color.Gray, Color.DarkGray, Color.Black),
    uiBackground = Color.White,
    uiBackgroundSecondary = Color.Black,
    uiBorder = Color(0x4D000000),
    textPrimary = Color.Black,
    textSecondary = Color.White,
    textHelp = Color.Black.copy(alpha = .5f),
    iconPrimary = Color(0xCC000000),
    iconSecondary = Color.White,
    iconActive = Color.White,
    iconInactive = Color.Black,
    error = Color(0xFFFFAE00),
    notificationBadge = Color.White
)

val Colors = lightColorPalette()

internal fun darkColorPalette() = lightColorPalette()

@Stable
class LoremPicsumColors(
    transparent: Color = Color.Transparent,
    brand: Color,
    brandSecondary: Color,
    brandGradient: List<Color>,
    uiBackground: Color,
    uiBackgroundSecondary: Color,
    uiBorder: Color,
    textPrimary: Color = brand,
    textSecondary: Color,
    textHelp: Color,
    iconPrimary: Color = brand,
    iconSecondary: Color,
    iconActive: Color,
    iconInactive: Color,
    error: Color,
    notificationBadge: Color = error,
    isDark: Boolean = false
) {
    var brand by mutableStateOf(brand)
        private set
    var brandSecondary by mutableStateOf(brandSecondary)
        private set
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var uiBackgroundSecondary by mutableStateOf(uiBackgroundSecondary)
        private set
    var uiBorder by mutableStateOf(uiBorder)
        private set
    var bradGradient by mutableStateOf(brandGradient)
        private set
    var iconActive by mutableStateOf(iconActive)
        private set
    var iconInactive by mutableStateOf(iconInactive)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textHelp by mutableStateOf(textHelp)
        private set
    var iconPrimary by mutableStateOf(iconPrimary)
        private set
    var iconSecondary by mutableStateOf(iconSecondary)
        private set
    var error by mutableStateOf(error)
        private set
    var notificationBadge by mutableStateOf(notificationBadge)
        private set
    var isDark by mutableStateOf(isDark)
        private set
    var transparent by mutableStateOf(transparent)
        private set

    fun update(other: LoremPicsumColors) {
        brand = other.brand
        brandSecondary = other.brandSecondary
        uiBackground = other.uiBackground
        uiBackgroundSecondary = other.uiBackgroundSecondary
        uiBorder = other.uiBorder
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        textHelp = other.textHelp
        iconPrimary = other.iconPrimary
        iconSecondary = other.iconSecondary
        error = other.error
        notificationBadge = other.notificationBadge
        isDark = other.isDark
        transparent = other.transparent
    }

    fun copy(): LoremPicsumColors = LoremPicsumColors(
        brand = brand,
        brandSecondary = brandSecondary,
        uiBackground = uiBackground,
        uiBackgroundSecondary = uiBackgroundSecondary,
        uiBorder = uiBorder,
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        textHelp = textHelp,
        iconPrimary = iconPrimary,
        iconSecondary = iconSecondary,
        error = error,
        notificationBadge = notificationBadge,
        isDark = isDark,
        brandGradient = bradGradient,
        iconActive = iconActive,
        iconInactive = iconInactive,
        transparent = transparent
    )
}

internal val LocalLoremPicsumColors = staticCompositionLocalOf { lightColorPalette() }
