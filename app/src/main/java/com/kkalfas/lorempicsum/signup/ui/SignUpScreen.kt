package com.kkalfas.lorempicsum.signup.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.common.ui.components.Input
import com.kkalfas.lorempicsum.common.ui.components.buttons.PrimaryButton
import com.kkalfas.lorempicsum.theme.ui.Theme
import com.kkalfas.lorempicsum.ui.components.AppToolbar

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit
) {
    SignUpContent(
        modifier = modifier,
        onButtonClick = navigateToHome
    )
}

@Composable
private fun SignUpContent(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    var mail by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Theme.colors.uiBackground)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .size(124.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
        )
        AppToolbar {
            Text(
                text = stringResource(id = R.string.signup_title),
                style = Theme.typography.title,
                color = Theme.colors.textPrimary,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Hey You!",
                style = Theme.typography.inputField,
                color = Theme.colors.textPrimary,
            )
        }
        Input(
            inputValue = mail,
            onUpdateInputValue = { mail = it },
            placeholderLabelId = R.string.signup_hint_email
        )
        Spacer(modifier = Modifier.height(16.dp))
        Input(
            inputValue = password,
            onUpdateInputValue = { password = it },
            placeholderLabelId = R.string.login_hint_password,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onClick = onButtonClick,
            labelId = R.string.signup_button_label
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignUpScreenPreview() {
    SignUpContent(
        onButtonClick = {}
    )
}
