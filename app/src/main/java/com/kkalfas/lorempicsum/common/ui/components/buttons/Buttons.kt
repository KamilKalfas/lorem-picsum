package com.kkalfas.lorempicsum.common.ui.components.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kkalfas.lorempicsum.theme.ui.Theme

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    @StringRes labelId: Int
) {
    PrimaryButton(
        modifier,
        onClick,
        enabled,
        stringResource(labelId)
    )
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    label: String,
) {
    val colors = ButtonDefaults.buttonColors(
        backgroundColor = Theme.colors.uiBackgroundSecondary,
        contentColor = Theme.colors.textSecondary,
        disabledBackgroundColor = Theme.colors.uiBackgroundSecondary.copy(alpha = 0.3f)
    )
    Button(
        modifier = modifier.heightIn(min = 52.dp),
        onClick = onClick,
        colors = colors,
        enabled = enabled,
        shape = MaterialTheme.shapes.small,
        content = {
            Text(text = label.uppercase(), style = Theme.typography.primaryButton)
        }
    )
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    @StringRes labelId: Int
) {
    SecondaryButton(
        modifier,
        onClick,
        enabled,
        stringResource(labelId)
    )
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    label: String
) {
    val colors = ButtonDefaults.buttonColors(
        backgroundColor = Theme.colors.uiBackground,
        contentColor = Theme.colors.textPrimary,
        disabledBackgroundColor = Theme.colors.uiBackground.copy(alpha = 0.7f)
    )
    Button(
        modifier = modifier.heightIn(min = 52.dp),
        onClick = onClick,
        colors = colors,
        enabled = enabled,
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(width = 2.dp, Theme.colors.textPrimary),
        content = {
            Text(text = label.uppercase(), style = Theme.typography.secondaryButton)
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewButtons() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Hello",
            onClick = {}
        )
        Spacer(Modifier.heightIn(4.dp))
        SecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            label = "There",
            onClick = {}
        )
    }
}
