package com.kkalfas.lorempicsum.common.ui.components.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
        backgroundColor = Color.Black,
        contentColor = Color.White,
        disabledBackgroundColor = Color.Black.copy(alpha = 0.3f)
    )
    Button(
        modifier = modifier.heightIn(min = 52.dp),
        onClick = onClick,
        colors = colors,
        enabled = enabled,
        shape = MaterialTheme.shapes.small,
        content = {
            Text(text = label)
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
        backgroundColor = Color.White,
        contentColor = Color.Black,
        disabledBackgroundColor = Color.White.copy(alpha = 0.7f)
    )
    Button(
        modifier = modifier.heightIn(min = 52.dp),
        onClick = onClick,
        colors = colors,
        enabled = enabled,
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(width = 2.dp, Color.Black),
        content = {
            Text(text = label)
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
