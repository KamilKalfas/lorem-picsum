package com.kkalfas.lorempicsum.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun VerticalGrid(
    columns: Int = 2,
    verticalPadding: Dp = 16.dp,
    items: List<@Composable (columnIndex: Int, rowIndex: Int) -> Unit>
) {
    val contentPerColumn = items.chunked(items.size / columns)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = verticalPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IntRange(0, columns -1).forEach { columnIndex ->
            val column = contentPerColumn[columnIndex]
            Column(
                modifier = Modifier.fillMaxHeight()
            ) {
                column.forEachIndexed { rowIndex, content ->
                    content(columnIndex, rowIndex)
                    if (verticalPadding != 0.dp && rowIndex != column.lastIndex) Spacer(
                        modifier = Modifier.height(
                            verticalPadding
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewVerticalGridTwoColumns() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        VerticalGrid(items = items())
    }
}

@Preview
@Composable
private fun PreviewVerticalGridTreeColumns() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        VerticalGrid(
            columns = 3,
            verticalPadding = 14.dp,
            items = items(15)
        )
    }
}

private fun items(repeatTimes: Int = 10): List<@Composable (Int, Int) -> Unit> {
    val rand = Random
    val content = mutableListOf<@Composable (Int, Int) -> Unit>()
    repeat(repeatTimes) {
        content.add { colIndex, rowIndex ->
            Box(
                modifier = Modifier.background(
                    Color(red = rand.nextInt(), blue = rand.nextInt(), green = rand.nextInt())
                )
            ) {
                Text(
                    text = "colIndex = $colIndex\nrowIndex = $rowIndex",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
    return content
}
