package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.domain.model.vacations

class GetAllVacations {
    operator fun invoke() = vacations
}