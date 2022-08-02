package com.commandiron.vacationchecklist.data.preferences

import android.content.SharedPreferences
import com.commandiron.vacationchecklist.domain.model.Vacation
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

    override fun saveActiveVacationId(id: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_SAVE_LOAD_ACTIVE_VACATION, id)
            .apply()
    }

    override fun loadActiveVacationId(): Int {
        return sharedPref.getInt(
            Preferences.KEY_SAVE_LOAD_ACTIVE_VACATION,
            0
        )
    }
}