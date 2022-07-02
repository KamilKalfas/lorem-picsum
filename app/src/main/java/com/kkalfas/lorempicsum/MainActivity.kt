package com.kkalfas.lorempicsum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.contentColorFor
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.kkalfas.lorempicsum.common.ui.components.bottomnavigation.BottomNavItem
import com.kkalfas.lorempicsum.common.ui.components.bottomnavigation.BottomNavigationComponent
import com.kkalfas.lorempicsum.theme.ui.AppTheme
import com.kkalfas.lorempicsum.theme.ui.Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
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

                    }
                }
            }
        }
    }
}
