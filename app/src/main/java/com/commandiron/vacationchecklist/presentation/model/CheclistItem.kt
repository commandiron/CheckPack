package com.commandiron.vacationchecklist.presentation.model

import androidx.annotation.DrawableRes
import com.commandiron.vacationchecklist.R

data class ChecklistItem(
    val id: Int,
    val name: String,
    val isChecked: Boolean = false,
    @DrawableRes
    val iconDrawable: Int
)

val checklistItems = listOf(
    ChecklistItem(
        id = 0,
        name = "Sunscreen",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        id = 1,
        name = "Sunglasses",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        id = 2,
        name = "Bathing suit",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        id = 3,
        name = "A good book",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        id = 0,
        name = "Sunscreen",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        id = 1,
        name = "Sunglasses",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        id = 2,
        name = "Bathing suit",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        id = 3,
        name = "A good book",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        id = 0,
        name = "Sunscreen",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        id = 1,
        name = "Sunglasses",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        id = 2,
        name = "Bathing suit",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        id = 3,
        name = "A good book",
        iconDrawable = R.drawable.backpack
    ),
)