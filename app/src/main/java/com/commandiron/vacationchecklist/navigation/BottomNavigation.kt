package com.commandiron.vacationchecklist.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
        NavigationItem.MyCheckListScreen,
        NavigationItem.AddVacationScreen,
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
                    .padding(
                        bottom = 24.dp,
                        start = 24.dp,
                        end = 24.dp
                    )
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
                    navigationItems.forEachIndexed { index, item ->
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
                                        .fillMaxWidth(0.3f)
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
//            Box {
//                NavigationBar(
//                    modifier = modifier.height(spacing.bottomNavigationHeight),
//                    containerColor = MaterialTheme.colorScheme.background,
//                    contentColor = MaterialTheme.colorScheme.onBackground
//                ) {
//                    val iconUnselectedHeight = (spacing.bottomNavigationHeight / 4).value
//                    navigationItems.forEachIndexed { index, item ->
//                        val iconHeightAnim = remember {
//                            Animatable(iconUnselectedHeight)
//                        }
//                        LaunchedEffect(key1 = currentRoute){
//                            if(currentRoute == item.route){
//                                launch {
//                                    bottomNavLineOffsetXAnim.animateTo(
//                                        targetValue = screenWidth.value / navigationItems.size * index,
//                                        animationSpec = tween(durationMillis = 700)
//                                    )
//                                }
//                                launch {
//                                    iconHeightAnim.animateTo(
//                                        targetValue = iconUnselectedHeight
//                                                + (spacing.bottomNavigationHeight / 10).value
//                                    )
//                                }
//                            }else{
//                                launch {
//                                    iconHeightAnim.animateTo(
//                                        targetValue = iconUnselectedHeight
//                                    )
//                                }
//                            }
//                        }
//                        NavigationBarItem(
//                            selected = currentRoute == item.route,
//                            onClick = { onBottomNavItemClick(item.route) },
//                            icon = {
//                                Icon(
//                                    modifier = Modifier.height(iconHeightAnim.value.dp),
//                                    imageVector = item.icon!!,
//                                    contentDescription = null,
//                                    tint = if(currentRoute == item.route) {
//                                        MaterialTheme.colorScheme.onBackground
//                                    } else MaterialTheme.colorScheme.onBackground.copy(alpha = 0.2f)
//                                )
//                            },
//                            label = {
//                                Text(
//                                    text = item.title,
//                                    style = MaterialTheme.typography.labelLarge.copy(
//                                        fontWeight = FontWeight.Bold
//                                    )
//                                )
//                            },
//                            alwaysShowLabel = false,
//                            colors = NavigationBarItemDefaults.colors(
//                                indicatorColor = MaterialTheme.colorScheme.background,
//                            )
//                        )
//                    }
//                }
//                Divider(
//                    modifier = Modifier
//                        .align(Alignment.BottomStart)
//                        .fillMaxWidth(1f / navigationItems.size)
//                        .offset(x = Dp(bottomNavLineOffsetXAnim.value))
//                )
//            }
        }
    }
}