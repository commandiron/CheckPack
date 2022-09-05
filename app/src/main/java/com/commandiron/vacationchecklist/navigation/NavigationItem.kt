package com.commandiron.vacationchecklist.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val route: String,
    val title: String = "",
    val selectedIcon: ImageVector? = null,
    val unSelectedIcon: ImageVector? = null,
){
    object HotSplashScreen : NavigationItem(
        route = "hotSplash"
    )
    object GetStartedScreen : NavigationItem(
        route = "getStarted"
    )
    object ChecklistScreen : NavigationItem(
        route = "checklist",
        title = "Checklist",
        selectedIcon = Icons.Default.LibraryAddCheck,
        unSelectedIcon = Icons.Outlined.LibraryAddCheck
    )
    object CreateVacationScreen : NavigationItem(
        route = "createVacation",
        title = "Create Vacation",
        selectedIcon = Icons.Default.Add,
        unSelectedIcon = Icons.Outlined.Add
    )
    object SettingsScreen : NavigationItem(
        route = "settings",
        title = "Settings",
        selectedIcon = Icons.Default.Settings,
        unSelectedIcon = Icons.Outlined.Settings
    )
}
