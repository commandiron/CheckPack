package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.domain.model.Vacation
import com.commandiron.vacationchecklist.domain.model.commonCheckItems
import com.commandiron.vacationchecklist.domain.model.skiTripCheckItems
import com.commandiron.vacationchecklist.domain.model.summerVacationCheckItems
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