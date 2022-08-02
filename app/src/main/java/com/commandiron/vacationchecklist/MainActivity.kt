package com.commandiron.vacationchecklist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.commandiron.vacationchecklist.domain.preferences.Preferences
import com.commandiron.vacationchecklist.navigation.BottomNavigation
import com.commandiron.vacationchecklist.navigation.NavigationItem
import com.commandiron.vacationchecklist.navigation.bottomNavigate
import com.commandiron.vacationchecklist.navigation.currentRoute
import com.commandiron.vacationchecklist.presentation.create_vacation.CreateVacationScreen
import com.commandiron.vacationchecklist.presentation.get_started.GetStartedScreen
import com.commandiron.vacationchecklist.presentation.hot_splash.HotSplashScreen
import com.commandiron.vacationchecklist.presentation.checklist.ChecklistScreen
import com.commandiron.vacationchecklist.presentation.settings.SettingsScreen
import com.commandiron.vacationchecklist.ui.theme.VacationCheckListTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    @OptIn(ExperimentalAnimationApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowHotSplash = preferences.loadShouldShowHotSplash()
        setContent {
            VacationCheckListTheme {
                val navController = rememberAnimatedNavController()
                CompositionLocalProvider {
                    Scaffold(
                        bottomBar = {
                            BottomNavigation(
                                currentRoute = navController.currentRoute(),
                                onBottomNavItemClick = {
                                    navController.popBackStack()
                                    navController.bottomNavigate(route = it)
                                }
                            )
                        },
                        backgroundColor = MaterialTheme.colorScheme.background
                    ) {
                        AnimatedNavHost(
                            navController = navController,
                            startDestination = if(shouldShowHotSplash) {
                                NavigationItem.HotSplashScreen.route
                            } else {
                                NavigationItem.ChecklistScreen.route
                            }
                        ){
                            composable(
                                route = NavigationItem.HotSplashScreen.route,
                                enterTransition = {
                                    when(initialState.destination.route){
                                        else -> null
                                    }
                                },
                                exitTransition = {
                                    when (targetState.destination.route) {
                                        else -> null
                                    }
                                }
                            ){
                                HotSplashScreen()
                            }
                            composable(
                                route = NavigationItem.GetStartedScreen.route,
                                enterTransition = {
                                    when(initialState.destination.route){
                                        else -> null
                                    }
                                },
                                exitTransition = {
                                    when (targetState.destination.route) {
                                        else -> null
                                    }
                                }
                            ){
                                GetStartedScreen()
                            }
                            composable(
                                route = NavigationItem.ChecklistScreen.route,
                                enterTransition = {
                                    when(initialState.destination.route){
                                        else -> null
                                    }
                                },
                                exitTransition = {
                                    when (targetState.destination.route) {
                                        else -> null
                                    }
                                }
                            ){
                                ChecklistScreen(
                                    navigate = {
                                        navController.navigate(it)
                                    }
                                )
                            }
                            composable(
                                route = NavigationItem.CreateVacationScreen.route,
                                enterTransition = {
                                    when(initialState.destination.route){
                                        else -> null
                                    }
                                },
                                exitTransition = {
                                    when (targetState.destination.route) {
                                        else -> null
                                    }
                                }
                            ){
                                CreateVacationScreen(
                                    navigate = {
                                        navController.navigate(it)
                                    }
                                )
                            }
                            composable(
                                route = NavigationItem.SettingsScreen.route,
                                enterTransition = {
                                    when(initialState.destination.route){
                                        else -> null
                                    }
                                },
                                exitTransition = {
                                    when (targetState.destination.route) {
                                        else -> null
                                    }
                                }
                            ){
                                SettingsScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}
