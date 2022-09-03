package com.commandiron.vacationchecklist.data.repository

import com.commandiron.vacationchecklist.data.local.checklistItem.ChecklistItemDao
import com.commandiron.vacationchecklist.data.mapper.toChecklistItem
import com.commandiron.vacationchecklist.data.mapper.toChecklistItemEntity
import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.domain.repository.Repository

class DefaultRepositoryImpl(
    private val checklistItemDao: ChecklistItemDao,
): Repository {

    override suspend fun insertChecklistItems(checklistItems: List<ChecklistItem>) {
        val checklistItemEntities = checklistItems.map { it.toChecklistItemEntity() }
        checklistItemDao.insertChecklistItems(*checklistItemEntities.toTypedArray())
    }

    override suspend fun getAllChecklistItems(): List<ChecklistItem> {
        return checklistItemDao.getAllChecklistItems().map { it.toChecklistItem() }
    }
}