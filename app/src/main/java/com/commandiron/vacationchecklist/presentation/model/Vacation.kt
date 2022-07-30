package com.commandiron.vacationchecklist.presentation.model

import androidx.annotation.DrawableRes
import com.commandiron.vacationchecklist.R

data class Vacation(
    val id: Int,
    val name: String,
    @DrawableRes
    val iconId: Int
)

val vacations = listOf(
    Vacation(
        id = 0,
        name = "Summer Holiday",
        iconId = R.drawable.ic_launcher_foreground
    ),
    Vacation(
        id = 1,
        name = "Winter Break",
        iconId = R.drawable.ic_launcher_foreground
    ),
    Vacation(
        id = 2,
        name = "Camping",
        iconId = R.drawable.ic_launcher_foreground
    ),
    Vacation(
        id = 3,
        name = "Digital Detox",
        iconId = R.drawable.ic_launcher_foreground
    ),
    Vacation(
        id = 4,
        name = "Backpacking",
        iconId = R.drawable.ic_launcher_foreground
    ),
)
