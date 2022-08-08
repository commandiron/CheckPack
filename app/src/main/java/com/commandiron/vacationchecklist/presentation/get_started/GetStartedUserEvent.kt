package com.commandiron.vacationchecklist.presentation.get_started

import com.commandiron.vacationchecklist.domain.model.Vacation

sealed class GetStartedUserEvent{
    data class OnSelect(val vacation: Vacation) : GetStartedUserEvent()
    data class OnNameChange(val text: String) : GetStartedUserEvent()
    data class OnFinish(val vacation: Vacation) : GetStartedUserEvent()
}
