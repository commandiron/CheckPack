package com.commandiron.vacationchecklist.data.repository

import com.commandiron.vacationchecklist.data.local.ChecklistDao
import com.commandiron.vacationchecklist.data.mapper.toCheckItem
import com.commandiron.vacationchecklist.data.mapper.toCheckItemEntity
import com.commandiron.vacationchecklist.domain.model.CheckItem
import com.commandiron.vacationchecklist.domain.repository.Repository

class DefaultRepositoryImpl(
    private val dao: ChecklistDao,
): Repository {

    override suspend fun insertCheckItems(checkItems: List<CheckItem>) {
        val checklistItemEntities = checkItems.map { it.toCheckItemEntity() }
        dao.insert(*checklistItemEntities.toTypedArray())
    }

    override suspend fun deleteAllCheckItems() {
        dao.deleteAll()
    }

    override suspend fun getAllCheckItems(): List<CheckItem> {
        return dao.getAll().map { it.toCheckItem() }
    }
}