package com.commandiron.vacationchecklist

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.commandiron.vacationchecklist.domain.preferences.Preferences
import com.commandiron.vacationchecklist.navigation.BottomNavigation
import com.commandiron.vacationchecklist.navigation.NavigationItem
import com.commandiron.vacationchecklist.navigation.bottomNavigate
import com.commandiron.vacationchecklist.navigation.currentRoute
import com.commandiron.vacationchecklist.presentation.create_vacation.CreateVacationScreen
import com.commandiron.vacationchecklist.presentation.get_started.GetStartedScreen
import com.commandiron.vacationchecklist.presentation.hot_splash.HotSplashScreen
import com.commandiron.vacationchecklist.presentation.checklist.ChecklistScreen
import com.commandiron.vacationchecklist.presentation.components.CustomSnackbar
import com.commandiron.vacationchecklist.presentation.settings.SettingsScreen
import com.commandiron.vacationchecklist.ui.theme.VacationCheckListTheme
import com.commandiron.vacationchecklist.util.getProvidedValues
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: AppViewModel by viewModels()
    @Inject
    lateinit var preferences: Preferences

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition{
            viewModel.state.isColdSplashScreenVisible
        }
        val shouldShowHotSplash = preferences.loadShouldShowHotSplash()
        setContent {
            VacationCheckListTheme {
                val navController = rememberAnimatedNavController()
                val systemUiController = rememberSystemUiController()
                val snackbarHostState = remember { SnackbarHostState() }
                systemUiController.setSystemBarsColor(
                    color = MaterialTheme.colorScheme.background
                )
                CompositionLocalProvider(
                    values = getProvidedValues(
                        snackbarHostState = snackbarHostState
                    )
                ) {
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
                        snackbarHost = {
                            SnackbarHost(snackbarHostState) { data ->
                                CustomSnackbar(data)
                            }
                        },
                        backgroundColor = MaterialTheme.colorScheme.background
                    ) {
                        AnimatedNavHost(
                            navController = navController,
                            startDestination = if(shouldShowHotSplash) {
                                NavigationItem.HotSplashScreen.route
                            } else {
                                NavigationItem.GetStartedScreen.route
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
                                HotSplashScreen(
                                    onFinish = {
                                        navController.popBackStack()
                                        navController.navigate(
                                            NavigationItem.GetStartedScreen.route
                                        )
                                    }
                                )
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
                                GetStartedScreen(
                                    navigate = {
                                        navController.popBackStack()
                                        navController.navigate(it)
                                    }
                                )
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
