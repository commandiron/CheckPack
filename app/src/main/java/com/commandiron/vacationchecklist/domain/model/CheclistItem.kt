package com.commandiron.vacationchecklist.domain.model

import com.commandiron.vacationchecklist.R
import java.util.*

data class ChecklistItem(
    val id: Int? = null,
    val name: String,
    val isChecked: Boolean = false,
    val iconDrawable: Int,
    val importanceLevel: Int,
    val gender: Int,
    val category: Int,
    val vacationType: Int = 0
){
    object ImportanceLevel{
        const val MUST = 0
        const val OPTIONAL = 1
    }
    object Gender{
        const val UNISEX = 0
        const val MAN = 1
        const val WOMAN = 2
    }
    object Category{
        const val PROOF_OF_IDENTITY = 0
        const val TECHNOLOGY = 1
        const val CLOTHING = 2
        const val HEALTH = 3
        const val TOILETRIES = 4
        const val OTHER = 5
    }
    object VacationType{
        const val COMMON = 0
        const val SUMMER_VACATION = 1
        const val SKI_TRIP = 1
    }
}

val commonChecklistItems = listOf(

    //MUST
    ChecklistItem(
        name = "Identification",
        iconDrawable = R.drawable.identification,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.PROOF_OF_IDENTITY
    ),
    ChecklistItem(
        name = "Passport",
        iconDrawable = R.drawable.passport,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.PROOF_OF_IDENTITY
    ),
    ChecklistItem(
        name = "Credit / Debit cards / Cash",
        iconDrawable = R.drawable.wallet,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.PROOF_OF_IDENTITY
    ),
    ChecklistItem(
        name = "Cell phone",
        iconDrawable = R.drawable.smartphone,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TECHNOLOGY
    ),
    ChecklistItem(
        name = "Cell phone charger",
        iconDrawable = R.drawable.charger,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TECHNOLOGY
    ),
    ChecklistItem(
        name = "Medication",
        iconDrawable = R.drawable.medication,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.HEALTH
    ),
    ChecklistItem(
        name = "Prescription glasses",
        iconDrawable = R.drawable.prescription_glasses,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.HEALTH
    ),
    ChecklistItem(
        name = "Sunscreen",
        iconDrawable = R.drawable.sun_block,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.HEALTH
    ),
    ChecklistItem(
        name = "Contact lens supplies",
        iconDrawable = R.drawable.contact_lens,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.HEALTH
    ),
    ChecklistItem(
        name = "Tickets(airplane, train, etc)",
        iconDrawable = R.drawable.tickets,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER
    ),
    ChecklistItem(
        name = "Reservations for hotel",
        iconDrawable = R.drawable.hotel_reservation,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER
    ),
    ChecklistItem(
        name = "Car rental",
        iconDrawable = R.drawable.car_rental,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER
    ),
    ChecklistItem(
        name = "A good book",
        iconDrawable = R.drawable.book,
        importanceLevel = ChecklistItem.ImportanceLevel.MUST,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER
    ),


    //OPTIONAL
    ChecklistItem(
        name = "Headphones",
        iconDrawable = R.drawable.headphones,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TECHNOLOGY
    ),
    ChecklistItem(
        name = "Electrical converters or travel adapters",
        iconDrawable = R.drawable.electrical_converters,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TECHNOLOGY
    ),
    ChecklistItem(
        name = "Camera / Video camera",
        iconDrawable = R.drawable.camera,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TECHNOLOGY
    ),
    ChecklistItem(
        name = "Camera Charger",
        iconDrawable = R.drawable.camera_charger,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TECHNOLOGY
    ),
    ChecklistItem(
        name = "Laptop or tablet",
        iconDrawable = R.drawable.laptop,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TECHNOLOGY
    ),
    ChecklistItem(
        name = "Laptop or tablet charger",
        iconDrawable = R.drawable.laptop_charger,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TECHNOLOGY
    ),
    ChecklistItem(
        name = "Portable Charger",
        iconDrawable = R.drawable.portable_charger,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TECHNOLOGY
    ),
    ChecklistItem(
        name = "Sunglasses",
        iconDrawable = R.drawable.sunglasses,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Watch",
        iconDrawable = R.drawable.watch,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "One casual outfit per day",
        iconDrawable = R.drawable.casual_outfit,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Sweater",
        iconDrawable = R.drawable.sweater,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Jacket",
        iconDrawable = R.drawable.jacket,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Underwear",
        iconDrawable = R.drawable.underwear,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Socks",
        iconDrawable = R.drawable.socks,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Extra shoes",
        iconDrawable = R.drawable.shoes,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Sandals",
        iconDrawable = R.drawable.sandals,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Pants",
        iconDrawable = R.drawable.pants,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Shorts",
        iconDrawable = R.drawable.shorts,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Jewelry",
        iconDrawable = R.drawable.jewelry,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Tank tops",
        iconDrawable = R.drawable.tank_tops,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Belt",
        iconDrawable = R.drawable.belt,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Pajamas",
        iconDrawable = R.drawable.pajamas,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Umbrella",
        iconDrawable = R.drawable.umbrella,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Raincoat",
        iconDrawable = R.drawable.raincoat,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Everyday bag (for carrying day items)",
        iconDrawable = R.drawable.everyday_bag,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING
    ),
    ChecklistItem(
        name = "Tampons or pads",
        iconDrawable = R.drawable.tampons_pad,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.WOMAN,
        category = ChecklistItem.Category.HEALTH
    ),
    ChecklistItem(
        name = "First aid kit (travel size)",
        iconDrawable = R.drawable.first_aid_kit,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.HEALTH
    ),
    ChecklistItem(
        name = "Toothbrush - Toothpaste",
        iconDrawable = R.drawable.toothbrush_toothpaste,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Personal care supplies",
        iconDrawable = R.drawable.personal_care,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Towel",
        iconDrawable = R.drawable.towel,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Comb / Brush",
        iconDrawable = R.drawable.comb,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Wet wipes and tissue paper",
        iconDrawable = R.drawable.wet_wipes,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Makeup",
        iconDrawable = R.drawable.makeup,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.WOMAN,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Razors",
        iconDrawable = R.drawable.razor,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Shaving cream",
        iconDrawable = R.drawable.shaving_cream,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.MAN,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "After shave",
        iconDrawable = R.drawable.after_shave,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.MAN,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Hand / Face cream",
        iconDrawable = R.drawable.hand_face_cream,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Nail clippers",
        iconDrawable = R.drawable.nail_clippers,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Parfume",
        iconDrawable = R.drawable.parfume,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Deodorant",
        iconDrawable = R.drawable.deodorant,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Shampoo - Conditioner",
        iconDrawable = R.drawable.shampoo_conditioner,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Soap",
        iconDrawable = R.drawable.soap,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Hand sanitizer",
        iconDrawable = R.drawable.hand_sanitizer,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Hairstyling products",
        iconDrawable = R.drawable.hair_spray,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.TOILETRIES
    ),
    ChecklistItem(
        name = "Pillow case",
        iconDrawable = R.drawable.pillow_case,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER
    ),
    ChecklistItem(
        name = "Laundry bag",
        iconDrawable = R.drawable.laundry_bag,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER
    ),
    ChecklistItem(
        name = "Toys",
        iconDrawable = R.drawable.toys,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER
    ),
    ChecklistItem(
        name = "Game console / Notebook",
        iconDrawable = R.drawable.game_console,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER
    ),
    ChecklistItem(
        name = "Board Games",
        iconDrawable = R.drawable.board_game,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER
    ),
    ChecklistItem(
        name = "Snacks",
        iconDrawable = R.drawable.snack,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER
    )
)

val summerVacationChecklistItems = listOf(

    //OPTIONAL
    ChecklistItem(
        name = "Swimwear",
        iconDrawable = R.drawable.swimwear,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING,
        vacationType = ChecklistItem.VacationType.SUMMER_VACATION
    ),
    ChecklistItem(
        name = "Beach Towel",
        iconDrawable = R.drawable.beach_towel,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING,
        vacationType = ChecklistItem.VacationType.SUMMER_VACATION
    ),
    ChecklistItem(
        name = "Summer Hat",
        iconDrawable = R.drawable.sun_hat,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING,
        vacationType = ChecklistItem.VacationType.SUMMER_VACATION
    ),
    ChecklistItem(
        name = "Water Shoes",
        iconDrawable = R.drawable.water_shoe,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SUMMER_VACATION
    ),
    ChecklistItem(
        name = "Snorkel",
        iconDrawable = R.drawable.snorkel,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SUMMER_VACATION
    ),
    ChecklistItem(
        name = "Beach Umbrella",
        iconDrawable = R.drawable.beach_umbrella,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SUMMER_VACATION
    ),
    ChecklistItem(
        name = "Beach Foldable Chair",
        iconDrawable = R.drawable.beach_chair,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SUMMER_VACATION
    ),
    ChecklistItem(
        name = "Frisbees, beach balls etc",
        iconDrawable = R.drawable.beach_ball,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SUMMER_VACATION
    ),
)

val skiTripChecklistItems = listOf(

    //OPTIONAL
    ChecklistItem(
        name = "Heavy Coat or Parka",
        iconDrawable = R.drawable.heavy_coat,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "All-Weather Boots",
        iconDrawable = R.drawable.all_weather_boots,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "Insulated Leather Gloves or Mittens",
        iconDrawable = R.drawable.leather_gloves,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "Insulated Hat",
        iconDrawable = R.drawable.winter_hat,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "Scarf",
        iconDrawable = R.drawable.scarf,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "Balaclava",
        iconDrawable = R.drawable.balaclava,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.CLOTHING,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "Ski-Board Equipments",
        iconDrawable = R.drawable.ski_board_equipments,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "Ski-Board Helmet",
        iconDrawable = R.drawable.ski_board_helmet,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "Ski-Board Glasses",
        iconDrawable = R.drawable.ski_board_glasses,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "Ski-Board Jacket",
        iconDrawable = R.drawable.ski_board_jacket,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "Ski-Board Pants",
        iconDrawable = R.drawable.ski_board_pants,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "Ski-Board Socks",
        iconDrawable = R.drawable.ski_board_socks,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "Ski-Board Boots",
        iconDrawable = R.drawable.ski_board_boots,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    ),
    ChecklistItem(
        name = "Ski-Board Gloves",
        iconDrawable = R.drawable.ski_board_gloves,
        importanceLevel = ChecklistItem.ImportanceLevel.OPTIONAL,
        gender = ChecklistItem.Gender.UNISEX,
        category = ChecklistItem.Category.OTHER,
        vacationType = ChecklistItem.VacationType.SKI_TRIP
    )
)













