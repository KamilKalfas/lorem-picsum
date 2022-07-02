package com.kkalfas.lorempicsum.common.ui.components.bottomnavigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.kkalfas.lorempicsum.R

sealed class BottomNavItem(val icon: ImageVector, @StringRes val titleId: Int) {
    object Discover : BottomNavItem(Icons.Default.Home, R.string.label_bottom_nav_home)
    object Search : BottomNavItem(Icons.Default.Search, R.string.label_bottom_nav_search)
    object Chat : BottomNavItem(Icons.Default.Chat, R.string.label_bottom_nav_chats)
    object Profile : BottomNavItem(Icons.Default.Person, R.string.label_bottom_nav_profile)
}
