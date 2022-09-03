package com.commandiron.vacationchecklist.data.repository

import com.commandiron.vacationchecklist.data.local.ChecklistItemDao
import com.commandiron.vacationchecklist.data.mapper.toChecklistItem
import com.commandiron.vacationchecklist.data.mapper.toChecklistItemEntity
import com.commandiron.vacationchecklist.domain.model.ChecklistItem
import com.commandiron.vacationchecklist.domain.repository.Repository

class DefaultRepositoryImpl(
    private val dao: ChecklistItemDao,
): Repository {

    override suspend fun insertChecklistItems(checklistItems: List<ChecklistItem>) {
        val checklistItemEntities = checklistItems.map { it.toChecklistItemEntity() }
        dao.insert(*checklistItemEntities.toTypedArray())
    }

    override suspend fun deleteAllChecklistItems() {
        dao.deleteAll()
    }

    override suspend fun getAllChecklistItems(): List<ChecklistItem> {
        return dao.getAll().map { it.toChecklistItem() }
    }
}