package com.kkalfas.lorempicsum.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    navigateToHome: () -> Unit
) {
    LoginContent(
        uiState = viewModel.uiState.collectAsState().value,
        onButtonClick = {
            navigateToHome()
        }
    )
}

@Composable
private fun LoginContent(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
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
                text = stringResource(id = R.string.login_title),
                style = Theme.typography.title,
                color = Theme.colors.textPrimary,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Welcome back",
                style = Theme.typography.inputField,
                color = Theme.colors.textPrimary,
            )
        }
        Input(
            inputValue = mail,
            onUpdateInputValue = { mail = it },
            placeholderLabelId = R.string.login_hint_email
        )
        Spacer(modifier = Modifier.height(16.dp))
        Input(
            inputValue = password,
            onUpdateInputValue = { password = it },
            placeholderLabelId = R.string.login_hint_password,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .imePadding()
                .padding(horizontal = 16.dp),
            onClick = onButtonClick,
            labelId = R.string.login_button_label
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    val uiState = LoginUiState(
        isLoading = false,
        error = null
    )

    LoginContent(
        uiState = uiState,
        onButtonClick = {}
    )
}
