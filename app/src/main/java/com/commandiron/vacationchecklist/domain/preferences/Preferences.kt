package com.commandiron.vacationchecklist.domain.preferences

interface Preferences {
    fun saveShouldShowHotSplash(shouldShow: Boolean)
    fun loadShouldShowHotSplash(): Boolean

    fun saveActiveVacationId(id: Int)
    fun loadActiveVacationId(): Int

    companion object {
        const val KEY_SHOULD_SHOW_HOT_SPLASH = "should_show_hotSplash"
        const val KEY_SAVE_LOAD_ACTIVE_VACATION = "save_load_active_vacation"
    }
}