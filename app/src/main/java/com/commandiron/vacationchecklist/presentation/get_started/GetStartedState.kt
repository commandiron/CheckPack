package com.commandiron.vacationchecklist.presentation.get_started

import com.commandiron.vacationchecklist.domain.model.Vacation

data class GetStartedState(
    val vacations: List<Vacation>? = null,
    val selectedVacation: Vacation? = null,
    val fakeLoading: Boolean = false,
    val fakeLoadingDelay: Long = 3000
)
