package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.domain.model.*
import com.commandiron.vacationchecklist.domain.repository.Repository

class InsertAllCheckItems(
    private val repository: Repository
) {
    suspend operator fun invoke(vacation: Vacation){
        when(vacation.id){
            0 -> {
                val checklistItems = commonCheckItems + summerVacationCheckItems
                repository.insertCheckItems(checklistItems)
            }
            1 -> {
                val checklistItems = commonCheckItems + skiTripCheckItems
                repository.insertCheckItems(checklistItems)
            }
        }
    }
}