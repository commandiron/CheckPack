package com.commandiron.vacationchecklist.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.commandiron.vacationchecklist.util.Strings

sealed class NavigationItem(
    val route: String,
    val title: String = Strings.EMPTY_STRING,
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
    object AddVacationScreen : NavigationItem(
        route = "addVacation",
        title = "Change Vacation",
        selectedIcon = Icons.Default.DirectionsCar,
        unSelectedIcon = Icons.Outlined.DirectionsCar
    )
    object SettingsScreen : NavigationItem(
        route = "settings",
        title = "Settings",
        selectedIcon = Icons.Default.Settings,
        unSelectedIcon = Icons.Outlined.Settings
    )
}
