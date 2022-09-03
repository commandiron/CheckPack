package com.commandiron.vacationchecklist.domain.model

import com.commandiron.vacationchecklist.R

data class Vacation(
    val id: Int,
    val name: String,
    val iconDrawable: Int,
)

val vacations = listOf(
    Vacation(
        id = 0,
        name = "Summer Vacation",
        iconDrawable = R.drawable.summer_vacation
    ),
    Vacation(
        id = 1,
        name = "Ski Trip",
        iconDrawable = R.drawable.ski_trip
    )
//    Vacation(
//        id = 2,
//        name = "Camping",
//        iconDrawable = R.drawable.camping_tent
//    ),
//    Vacation(
//        id = 3,
//        name = "Caravan",
//        iconDrawable = R.drawable.caravan
//    ),
//    Vacation(
//        id = 4,
//        name = "Digital Detox",
//        iconDrawable = R.drawable.digital
//    ),
//    Vacation(
//        id = 5,
//        name = "Backpacking",
//        iconDrawable = R.drawable.backpack
//    )
)
