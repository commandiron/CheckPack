package com.commandiron.vacationchecklist.presentation.hot_splash

import androidx.lifecycle.ViewModel
import com.commandiron.vacationchecklist.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HotSplashViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    fun setShouldShowSplashScreenFalse(){
        preferences.saveShouldShowHotSplash(false)
    }
}