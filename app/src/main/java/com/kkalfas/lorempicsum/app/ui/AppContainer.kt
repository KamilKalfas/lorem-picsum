package com.kkalfas.lorempicsum.app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kkalfas.lorempicsum.common.ui.components.bottomnavigation.BottomNavItem
import com.kkalfas.lorempicsum.common.ui.components.bottomnavigation.BottomNavigationComponent
import com.kkalfas.lorempicsum.theme.ui.AppTheme
import com.kkalfas.lorempicsum.theme.ui.Theme

@Composable
fun AppContainer() {
    AppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            drawerBackgroundColor = Theme.colors.uiBackground,
            drawerContentColor = contentColorFor(Theme.colors.uiBackground),
            drawerScrimColor = DrawerDefaults.scrimColor,
            backgroundColor = Theme.colors.uiBackground,
            contentColor = Theme.colors.brandSecondary,
            bottomBar = {
                BottomNavigationComponent(
                    selectedNavigation = BottomNavItem.Discover,
                    onNavigationSelected = { selected ->
                        // TODO add navigation
                    }
                )
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // TODO app content
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewAppContainer() {
    AppContainer()
}
