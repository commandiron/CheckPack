package com.commandiron.vacationchecklist.presentation.hot_splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HotSplashScreen(
    viewModel: HotSplashViewModel = hiltViewModel(),
) {
    LaunchedEffect(key1 = Unit){
        viewModel.setShouldShowSplashScreenFalse()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "HotSplashScreen")
    }
}