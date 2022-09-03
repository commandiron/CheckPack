package com.commandiron.vacationchecklist.domain.use_cases

import com.commandiron.vacationchecklist.domain.model.CheckItem
import com.commandiron.vacationchecklist.domain.repository.Repository

class InsertCheckItem(
    private val repository: Repository
) {
    suspend operator fun invoke(checkItem: CheckItem){
        repository.insertCheckItems(listOf(checkItem))
    }
}