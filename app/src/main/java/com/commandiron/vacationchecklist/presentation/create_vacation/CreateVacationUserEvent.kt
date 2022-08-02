package com.commandiron.vacationchecklist.presentation.create_vacation

import com.commandiron.vacationchecklist.domain.model.Vacation

sealed class CreateVacationUserEvent{
    data class OnSelect(val vacation: Vacation) : CreateVacationUserEvent()
    data class OnNameChange(val text: String) : CreateVacationUserEvent()
    object OnFinish : CreateVacationUserEvent()
    object OnAlertDialogDismiss : CreateVacationUserEvent()
    data class OnAlertDialogConfirm(val vacation: Vacation) : CreateVacationUserEvent()
}
