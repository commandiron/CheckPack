package com.commandiron.vacationchecklist.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.util.NoRippleTheme

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    currentRoute: String?,
    onBottomNavItemClick:(String) -> Unit
) {
    val spacing = LocalSpacing.current
    val navigationItems = listOf(
        NavigationItem.ChecklistScreen,
        NavigationItem.CreateVacationScreen,
        NavigationItem.SettingsScreen
    )
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        AnimatedVisibility(
            visible = navigationItems.map { it.route }.contains(currentRoute),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Surface(
                modifier = Modifier
                    .padding(spacing.bottomNavigationPadding)
                    .height(spacing.bottomNavigationHeight)
                    .fillMaxWidth(),
                color = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                shape = RoundedCornerShape(spacing.spaceExtraLarge)
            ) {
                Row(
                    modifier
                        .fillMaxSize()
                        .padding(horizontal = spacing.spaceLarge)
                ) {
                    navigationItems.forEach { item ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .clickable { onBottomNavItemClick(item.route) },
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .fillMaxHeight(0.40f)
                                        .aspectRatio(1f),
                                    imageVector = if(currentRoute == item.route) {
                                        item.selectedIcon!!
                                    } else item.unSelectedIcon!!,
                                    contentDescription = null,
                                    tint = if(currentRoute == item.route) {
                                        MaterialTheme.colorScheme.onPrimaryContainer
                                    } else MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.3f)
                                )
                                Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
                                AnimatedVisibility(
                                    visible = currentRoute == item.route
                                ) {
                                    Text(
                                        text = item.title,
                                        style = MaterialTheme.typography.labelLarge.copy(
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}