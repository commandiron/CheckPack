package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.R
import com.commandiron.vacationchecklist.domain.model.*

class GetVacations {
    operator fun invoke(): List<Vacation> {
        return vacations
    }
}

private val vacations = listOf(
    Vacation(
        id = 0,
        name = "Summer Vacation",
        iconDrawable = R.drawable.beach_chair,
        checklistItems = commonChecklistItems + summerVacationChecklistItems
    ),
    Vacation(
        id = 1,
        name = "Ski Trip",
        iconDrawable = R.drawable.snowboard,
        checklistItems = commonChecklistItems + skiTripChecklistItems
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