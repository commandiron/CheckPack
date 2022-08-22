package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.R
import com.commandiron.vacationchecklist.domain.model.*

class GetVacations {
    operator fun invoke(): List<Vacation> {
        return vacations
    }
}