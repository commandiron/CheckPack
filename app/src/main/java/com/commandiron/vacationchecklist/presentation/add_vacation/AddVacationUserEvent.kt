package com.commandiron.vacationchecklist.presentation.add_vacation

import com.commandiron.vacationchecklist.presentation.model.Vacation

sealed class AddVacationUserEvent{
    data class OnSelect(val vacation: Vacation) : AddVacationUserEvent()
    data class OnNameChange(val text: String) : AddVacationUserEvent()
    object OnFinish : AddVacationUserEvent()
}
