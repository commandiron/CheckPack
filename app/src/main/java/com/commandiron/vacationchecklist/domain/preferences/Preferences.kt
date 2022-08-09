package com.commandiron.vacationchecklist.domain.preferences

interface Preferences {
    fun saveShouldShowHotSplash(shouldShow: Boolean)
    fun loadShouldShowHotSplash(): Boolean

    fun saveActiveVacationId(id: Int)
    fun loadActiveVacationId(): Int

    fun saveShouldDoubleCheck(shouldDoubleCheck: Boolean)
    fun loadShouldDoubleCheck(): Boolean

    fun saveShouldShowGridView(shouldShow: Boolean)
    fun loadShouldShowGridView(): Boolean

    fun saveListScale(scale: Int)
    fun loadListScale(): Int

    companion object {
        const val KEY_SHOULD_SHOW_HOT_SPLASH = "should_show_hotSplash"
        const val KEY_SAVE_LOAD_ACTIVE_VACATION = "save_load_active_vacation"
        const val KEY_SHOULD_DOUBLE_CHECK = "should_double_check"
        const val KEY_SHOULD_SHOW_GRID_VIEW = "should_show_grid_view"
        const val KEY_SAVE_LOAD_LIST_SCALE = "save_load_list_scale"
    }
}