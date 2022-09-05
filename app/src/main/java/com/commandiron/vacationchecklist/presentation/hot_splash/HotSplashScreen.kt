package com.commandiron.vacationchecklist.presentation.hot_splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.commandiron.vacationchecklist.presentation.components.AppLogoWithName
import com.commandiron.vacationchecklist.util.LocalSpacing
import com.commandiron.vacationchecklist.presentation.components.FromCompanyComponent
import kotlinx.coroutines.delay

@Composable
fun HotSplashScreen(
    viewModel: HotSplashViewModel = hiltViewModel(),
    onFinish:() -> Unit
) {
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = Unit){
        viewModel.setShouldShowSplashScreenFalse()
        delay(viewModel.hotSplashDelay)
        onFinish()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AppLogoWithName()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = spacing.spaceExtraLarge),
        contentAlignment = Alignment.BottomCenter
    ) {
        FromCompanyComponent()
    }
}