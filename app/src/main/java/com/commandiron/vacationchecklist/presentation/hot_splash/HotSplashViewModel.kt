package com.commandiron.vacationchecklist.presentation.hot_splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.commandiron.vacationchecklist.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HotSplashViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    var hotSplashDelay by mutableStateOf(5000L)

    fun setShouldShowSplashScreenFalse(){
        preferences.saveShouldShowHotSplash(false)
    }
}
