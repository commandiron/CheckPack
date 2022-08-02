package com.commandiron.vacationchecklist.presentation.create_vacation

import com.commandiron.vacationchecklist.domain.model.Vacation

data class CreateVacationState(
    val vacations: List<Vacation>? = null,
    val selectedVacation: Vacation? = null,
    val showAlertDialog: Boolean = false,
    val fakeLoading: Boolean = false
)
