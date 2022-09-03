package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.domain.model.*
import com.commandiron.vacationchecklist.domain.repository.Repository

class InsertAllChecklistItems(
    private val repository: Repository
) {
    suspend operator fun invoke(vacation: Vacation){
        when(vacation.id){
            0 -> {
                val checklistItems = commonChecklistItems + summerVacationChecklistItems
                repository.insertChecklistItems(checklistItems)
            }
            1 -> {
                val checklistItems = commonChecklistItems + skiTripChecklistItems
                repository.insertChecklistItems(checklistItems)
            }
        }
    }
}