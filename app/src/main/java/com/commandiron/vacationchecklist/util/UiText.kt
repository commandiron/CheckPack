package com.commandiron.vacationchecklist.util

import android.content.Context
import androidx.annotation.StringRes

sealed class UiText {
    class StringResource(
        @StringRes val resId: Int,
        vararg val args: Any
    ): UiText()

    fun asString(context: Context): String {
        return when(this) {
            is StringResource -> context.getString(resId, *args)
        }
    }
}
