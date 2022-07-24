package com.kkalfas.lorempicsum.common.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.theme.ui.Theme

@Composable
fun Input(
    modifier: Modifier = Modifier,
    inputValue: TextFieldValue,
    @StringRes placeholderLabelId: Int? = null,
    @StringRes labelId: Int? = null,
    onUpdateInputValue: (input: TextFieldValue) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
) {
    val inputUnFocusedColors = TextFieldDefaults.outlinedTextFieldColors(
        unfocusedBorderColor = Color.Transparent,
        errorBorderColor = Color.Transparent,
        backgroundColor = Theme.colors.uiBackground,
        textColor = Theme.colors.textHelp,
        placeholderColor = Theme.colors.textHelp,
    )
    val inputFocusedColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.Transparent,
        errorBorderColor = Color.Transparent,
        backgroundColor = Theme.colors.uiBackground,
        textColor = Theme.colors.textPrimary
    )

    var colors by remember { mutableStateOf(inputUnFocusedColors) }
    val label: @Composable (() -> Unit)? = if (labelId != null) {
        { Text(text = stringResource(id = labelId), style = Theme.typography.inputField) }
    } else null
    val placeholder: @Composable (() -> Unit)? = if (placeholderLabelId != null) {
        {
            Text(
                text = stringResource(id = placeholderLabelId),
                style = Theme.typography.inputField
            )
        }
    } else null
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged {
                colors = if (it.hasFocus) inputFocusedColors
                else inputUnFocusedColors
            }
            .padding(horizontal = 16.dp)
            .height(52.dp)
            .border(1.dp, Theme.colors.textPrimary),
        value = inputValue,
        onValueChange = onUpdateInputValue,
        label = label,
        placeholder = placeholder,
        colors = colors,
        singleLine = true,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewInput() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Input(
            inputValue = TextFieldValue(""),
            placeholderLabelId = R.string.app_name,
            onUpdateInputValue = {}
        )
    }
}
