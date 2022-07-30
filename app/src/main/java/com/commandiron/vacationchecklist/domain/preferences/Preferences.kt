package com.commandiron.vacationchecklist.domain.preferences

interface Preferences {
    fun saveShouldShowHotSplash(shouldShow: Boolean)
    fun loadShouldShowHotSplash(): Boolean

    companion object {
        const val KEY_SHOULD_SHOW_HOT_SPLASH = "should_show_hotSplash"
    }
}