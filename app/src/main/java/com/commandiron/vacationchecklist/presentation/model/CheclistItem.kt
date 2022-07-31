package com.commandiron.vacationchecklist.presentation.model

import androidx.annotation.DrawableRes
import com.commandiron.vacationchecklist.R

data class ChecklistItem(
    val id: Int = 0,
    val name: String,
    val isChecked: Boolean = true,
    @DrawableRes
    val iconDrawable: Int,
    val importanceLevel: ImportanceLevel,
    val vacationTypes: List<VacationType> = listOf(VacationType.ALL),
    val bannedVacationTypes: List<VacationType> = listOf()
)

val checklistItems = listOf(



    //Common
    ChecklistItem(
        name = "Identification",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.MUST
    ),
    ChecklistItem(
        name = "Passport",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.MUST
    ),
    ChecklistItem(
        name = "Credit / Debit cards / Cash",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.MUST
    ),
    ChecklistItem(
        name = "Cell phone / Charger",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.MUST
    ),
    ChecklistItem(
        name = "Charger",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.MUST
    ),
    ChecklistItem(
        name = "Medication",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.MUST
    ),
    ChecklistItem(
        name = "Tickets(airplane, train, etc)",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.MUST
    ),
    ChecklistItem(
        name = "Reservations for hotel / Car rental",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.MUST
    ),
    ChecklistItem(
        name = "Glasses - contact lens supplies",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.MUST
    ),
    ChecklistItem(
        name = "Sunscreen",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.MUST
    ),
    ChecklistItem(
        name = "Electrical converters or travel adapters",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Camera / Video camera / Charger",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Headphones",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Laptop or tablet",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Portable Charger",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Sunglasses",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Watch",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "One casual outfit per day",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Sweater or jacket",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Underwear",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Socks",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Extra shoes",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Sandals",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Pants",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY,
    ),
    ChecklistItem(
        name = "Shorts",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Towel",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "A good book",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY
    ),
    ChecklistItem(
        name = "Tank tops",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Hat",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Belt",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Comb / Brush",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL,
    ),
    ChecklistItem(
        name = "Pajamas",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Pillow case",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Umbrella / Poncho",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Everyday bag (for carrying day items)",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Laundry bag",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Toothbrush - Toothpaste",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Makeup",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Razors",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Nail clippers",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Shaving cream",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Lotion",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Personal hygiene supplies",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Deodorant",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Shampoo - Conditioner",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Soap / Face wash",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Hand sanitizer",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Hairstyling products",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "First aid kit (travel size)",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Toys",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Notebook / Game console",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Board Games",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),
    ChecklistItem(
        name = "Snacks",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL
    ),



    //Summer holiday
    ChecklistItem(
        name = "Swimwear",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY,
        vacationTypes = listOf(
            VacationType.SUMMER_HOLIDAY
        )
    ),
    ChecklistItem(
        name = "Beach Towel",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.NECESSARY,
        vacationTypes = listOf(
            VacationType.SUMMER_HOLIDAY
        )
    ),
    ChecklistItem(
        name = "Cover-ups",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL,
        vacationTypes = listOf(
            VacationType.SUMMER_HOLIDAY
        ),
    ),
    ChecklistItem(
        name = "Water Shoes",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL,
        vacationTypes = listOf(
            VacationType.SUMMER_HOLIDAY
        ),
    ),
    ChecklistItem(
        name = "Snorkel",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL,
        vacationTypes = listOf(
            VacationType.SUMMER_HOLIDAY
        ),
    ),
    ChecklistItem(
        name = "Beach Umbrella",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL,
        vacationTypes = listOf(
            VacationType.SUMMER_HOLIDAY
        ),
    ),
    ChecklistItem(
        name = "Beach Foldable Chair",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL,
        vacationTypes = listOf(
            VacationType.SUMMER_HOLIDAY
        ),
    ),
    ChecklistItem(
        name = "Frisbees, beach balls etc",
        iconDrawable = R.drawable.backpack,
        importanceLevel = ImportanceLevel.OPTIONAL,
        vacationTypes = listOf(
            VacationType.SUMMER_HOLIDAY
        ),
    ),
)













