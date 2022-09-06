package com.commandiron.vacationchecklist.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
                color = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
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
                                        text = stringResource(item.titleResource),
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