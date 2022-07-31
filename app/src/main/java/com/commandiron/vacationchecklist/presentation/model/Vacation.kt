package com.commandiron.vacationchecklist.presentation.model

import androidx.annotation.DrawableRes
import com.commandiron.vacationchecklist.R

data class Vacation(
    val id: Int,
    val name: String,
    @DrawableRes
    val iconDrawable: Int
)

val vacations = listOf(
    Vacation(
        id = 0,
        name = "Summer Holiday",
        iconDrawable = R.drawable.beach_chair
    ),
    Vacation(
        id = 1,
        name = "Winter Break",
        iconDrawable = R.drawable.snowboard
    ),
    Vacation(
        id = 2,
        name = "Camping",
        iconDrawable = R.drawable.camping_tent
    ),
    Vacation(
        id = 3,
        name = "Caravan",
        iconDrawable = R.drawable.caravan
    ),
    Vacation(
        id = 4,
        name = "Digital Detox",
        iconDrawable = R.drawable.digital
    ),
    Vacation(
        id = 5,
        name = "Backpacking",
        iconDrawable = R.drawable.backpack
    ),
)
