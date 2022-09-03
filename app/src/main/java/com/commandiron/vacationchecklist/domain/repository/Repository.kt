package com.commandiron.vacationchecklist.domain.repository

import com.commandiron.vacationchecklist.domain.model.CheckItem

interface Repository {
    suspend fun insertCheckItems(checkItems: List<CheckItem>)
    suspend fun deleteAllCheckItems()
    suspend fun getAllCheckItems(): List<CheckItem>
}