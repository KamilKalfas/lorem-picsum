package com.kkalfas.lorempicsum.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.theme.ui.Theme

@Composable
fun HorizontalSection(
    scrollState: ScrollState,
    @StringRes headerLabel: Int,
    feed: List<@Composable () -> Unit>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = stringResource(id = headerLabel),
            color = Theme.colors.textPrimary,
            style = Theme.typography.contentHeader
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            feed.forEach {
                it.invoke()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHorizontalScroll() {
    fun feed(): List<@Composable () -> Unit> {
        return mutableListOf<@Composable () -> Unit>().apply {
            IntRange(0, 9).forEach { int ->
                add {
                    Box(modifier = Modifier.size(60.dp)) {
                        Text(text = "Text#$int")

                    }
                }
            }
        }
    }

    Column {
        HorizontalSection(
            scrollState = rememberScrollState(),
            headerLabel = R.string.discover_browse_all_label,
            feed = feed()
        )
    }
}
