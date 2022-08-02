package com.commandiron.vacationchecklist.domain.model

import androidx.room.TypeConverter
import com.commandiron.vacationchecklist.R
import java.util.*

data class ChecklistItem(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val isChecked: Boolean = false,
    val iconDrawable: Int
)

val commonChecklistItems = listOf(

    //MUST
    ChecklistItem(
        name = "Identification",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Passport",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Credit / Debit cards / Cash",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Cell phone / Charger",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Charger",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Medication",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Tickets(airplane, train, etc)",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Reservations for hotel / Car rental",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Glasses - contact lens supplies",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Sunscreen",
        iconDrawable = R.drawable.backpack
    ),

    //NECESSARY
    ChecklistItem(
        name = "Electrical converters or travel adapters",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Camera / Video camera / Charger",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Headphones",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Laptop or tablet",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Portable Charger",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Sunglasses",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Watch",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "One casual outfit per day",
        iconDrawable = R.drawable.backpack
    ),
    ChecklistItem(
        name = "Sweater or jacket",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Underwear",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Socks",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Extra shoes",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Sandals",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Pants",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Shorts",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Towel",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "A good book",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Tank tops",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Hat",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Belt",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Comb / Brush",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Pajamas",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Pillow case",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Umbrella / Poncho",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Everyday bag (for carrying day items)",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Laundry bag",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Toothbrush - Toothpaste",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Makeup",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Razors",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Nail clippers",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Shaving cream",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Lotion",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Personal hygiene supplies",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Tampons or pads",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Deodorant",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Shampoo - Conditioner",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Soap / Face wash",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Hand sanitizer",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Hairstyling products",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "First aid kit (travel size)",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Toys",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Notebook / Game console",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Board Games",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Snacks",
        iconDrawable = R.drawable.backpack
    )
)

val summerVacationChecklistItems = listOf(
    ChecklistItem(
        name = "Swimwear",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Beach Towel",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Cover-ups",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Water Shoes",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Snorkel",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Beach Umbrella",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Beach Foldable Chair",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Frisbees, beach balls etc",
        iconDrawable = R.drawable.backpack,
    ),
)

val skiTripChecklistItems = listOf(
    ChecklistItem(
        name = "Heavy Coat or Parka",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "All-Weather Boots",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Snow Pants or Bibs",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Insulated Hat",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Finger Gloves",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Insulated Leather Gloves or Mittens",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Scarf",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Balaclava",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Ski-Board Equipments",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Ski-Board Helmet",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Ski-Board Glasses",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Ski-Board Suits",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Ski-Board Pants",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Ski-Board Socks",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Ski-Board Boots",
        iconDrawable = R.drawable.backpack,
    ),
    ChecklistItem(
        name = "Ski-Board Gloves",
        iconDrawable = R.drawable.backpack,
    )
)













