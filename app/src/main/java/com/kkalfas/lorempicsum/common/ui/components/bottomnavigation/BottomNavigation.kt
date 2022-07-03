package com.kkalfas.lorempicsum.common.ui.components.bottomnavigation

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kkalfas.lorempicsum.theme.ui.Theme

@Composable
fun BottomNavigationComponent(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Theme.colors.uiBackground,
    contentColor: Color = Theme.colors.iconPrimary,
    uiBorderColor: Color = Theme.colors.uiBorder,
    selectedNavigation: BottomNavItem,
    onNavigationSelected: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem.Discover,
        BottomNavItem.Search,
        BottomNavItem.Chat,
        BottomNavItem.Profile
    )

    BottomNavigation(
        modifier = modifier
            .navigationBarsPadding()
            .drawBehind {
                drawLine(
                    color = uiBorderColor,
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = size.width, y = 0f),
                    strokeWidth = Stroke.DefaultMiter
                )
            },
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = 0.dp
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(imageVector = item.icon, contentDescription = stringResource(item.titleId))
                },
                alwaysShowLabel = false,
                selected = selectedNavigation == item,
                onClick = { onNavigationSelected(item) }
            )
        }
    }
}
