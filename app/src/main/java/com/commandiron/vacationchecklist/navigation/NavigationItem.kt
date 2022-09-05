package com.commandiron.vacationchecklist.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LibraryAddCheck
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.LibraryAddCheck
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.commandiron.vacationchecklist.R

sealed class NavigationItem(
    val route: String,
    val titleResource: Int = 0,
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
        titleResource = R.string.checklist,
        selectedIcon = Icons.Default.LibraryAddCheck,
        unSelectedIcon = Icons.Outlined.LibraryAddCheck
    )
    object CreateVacationScreen : NavigationItem(
        route = "createVacation",
        titleResource = R.string.create_vacation,
        selectedIcon = Icons.Default.Add,
        unSelectedIcon = Icons.Outlined.Add
    )
    object SettingsScreen : NavigationItem(
        route = "settings",
        titleResource = R.string.settings,
        selectedIcon = Icons.Default.Settings,
        unSelectedIcon = Icons.Outlined.Settings
    )
}
