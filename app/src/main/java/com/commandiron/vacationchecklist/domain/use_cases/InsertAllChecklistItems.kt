package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.domain.model.*
import com.commandiron.vacationchecklist.domain.repository.Repository

class InsertAllChecklistItems(
    private val repository: Repository
) {
    suspend operator fun invoke(vacation: Vacation){
        println(commonChecklistItems.size)
        println(summerVacationChecklistItems.size)
        println(skiTripChecklistItems.size)
        when(vacation.id){
            0 -> {
                val checklistItems = commonChecklistItems + summerVacationChecklistItems
                println("1: " + checklistItems.size)
                repository.insertChecklistItems(checklistItems)
            }
            1 -> {
                val checklistItems = commonChecklistItems + skiTripChecklistItems
                println("2: " + checklistItems.size)
                repository.insertChecklistItems(checklistItems)
            }
        }
    }
}