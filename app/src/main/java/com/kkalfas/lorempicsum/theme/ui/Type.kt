package com.kkalfas.lorempicsum.theme.ui

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Stable
class LoremPicusmTypography(
    title: TextStyle,
    contentHeader: TextStyle,
    contentSubtitle: TextStyle,
    contentDescription: TextStyle,
    paragraph: TextStyle,
    primaryButton: TextStyle,
    secondaryButton: TextStyle,
    inputField: TextStyle
) {
    var title by mutableStateOf(title)
        private set
    var contentHeader by mutableStateOf(contentHeader)
        private set
    var contentSubtitle by mutableStateOf(contentSubtitle)
        private set
    var contentDescription by mutableStateOf(contentDescription)
        private set
    var paragraph by mutableStateOf(paragraph)
        private set
    var primaryButton by mutableStateOf(primaryButton)
        private set
    var secondaryButton by mutableStateOf(secondaryButton)
        private set
    var inputField by mutableStateOf(inputField)
        private set

    fun update(other: LoremPicusmTypography) {
        title = other.title
        contentHeader = other.contentHeader
        contentSubtitle = other.contentSubtitle
        contentDescription = other.contentDescription
        paragraph = other.paragraph
        primaryButton = other.primaryButton
        secondaryButton = other.secondaryButton
        inputField = other.inputField
    }

    fun copy(): LoremPicusmTypography = LoremPicusmTypography(
        title = title,
        contentHeader = contentHeader,
        contentSubtitle = contentSubtitle,
        contentDescription = contentDescription,
        paragraph = paragraph,
        primaryButton = primaryButton,
        secondaryButton = secondaryButton,
        inputField = inputField
    )
}

internal val LocalLoremPicsumType = staticCompositionLocalOf { typography() }

private fun typography() = LoremPicusmTypography(
    title = TextStyle(
        fontSize = 36.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        lineHeight = 40.sp
    ),
    contentHeader = TextStyle(
        fontSize = 13.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Black,
        lineHeight = 15.sp
    ),
    contentSubtitle = TextStyle(
        fontSize = 13.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        lineHeight = 15.sp
    ),
    contentDescription = TextStyle(
        fontSize = 11.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        lineHeight = 13.sp
    ),
    paragraph = TextStyle(
        fontSize = 15.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        lineHeight = 17.sp
    ),
    primaryButton = TextStyle(
        fontSize = 13.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Black,
        lineHeight = 15.sp,
    ),
    secondaryButton = TextStyle(
        fontSize = 13.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Black,
        lineHeight = 15.sp
    ),
    inputField = TextStyle(
        fontSize = 15.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        lineHeight = 17.5.sp
    ),
)
