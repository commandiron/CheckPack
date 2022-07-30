package com.commandiron.vacationchecklist.data.preferences

import android.content.SharedPreferences
import com.commandiron.vacationchecklist.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPref: SharedPreferences
): Preferences {
    override fun saveShouldShowHotSplash(shouldShow: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.KEY_SHOULD_SHOW_HOT_SPLASH, shouldShow)
            .apply()
    }

    override fun loadShouldShowHotSplash(): Boolean {
        return sharedPref.getBoolean(
            Preferences.KEY_SHOULD_SHOW_HOT_SPLASH,
            true
        )
    }
}