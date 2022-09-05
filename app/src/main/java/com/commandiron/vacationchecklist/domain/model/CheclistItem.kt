package com.commandiron.vacationchecklist.domain.model

import com.commandiron.vacationchecklist.R

data class CheckItem(
    val id: Int? = null,
    val name: String,
    val isChecked: Boolean = false,
    val isMarked: Boolean = false,
    val iconDrawable: Int,
    val importanceLevel: ImportanceLevel,
    val gender: Int,
    val category: Int,
    val vacationType: Int = 0
){
    enum class ImportanceLevel{
        MUST, OPTIONAL
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

val commonCheckItems = listOf(

    //MUST
    CheckItem(
        name = "Identification",
        iconDrawable = R.drawable.identification,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.PROOF_OF_IDENTITY
    ),
    CheckItem(
        name = "Passport",
        iconDrawable = R.drawable.passport,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.PROOF_OF_IDENTITY
    ),
    CheckItem(
        name = "Credit / Debit cards / Cash",
        iconDrawable = R.drawable.wallet,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.PROOF_OF_IDENTITY
    ),
    CheckItem(
        name = "Cell phone",
        iconDrawable = R.drawable.smartphone,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TECHNOLOGY
    ),
    CheckItem(
        name = "Cell phone charger",
        iconDrawable = R.drawable.charger,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TECHNOLOGY
    ),
    CheckItem(
        name = "Medication",
        iconDrawable = R.drawable.medication,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.HEALTH
    ),
    CheckItem(
        name = "Prescription glasses",
        iconDrawable = R.drawable.prescription_glasses,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.HEALTH
    ),
    CheckItem(
        name = "Sunscreen",
        iconDrawable = R.drawable.sun_block,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.HEALTH
    ),
    CheckItem(
        name = "Contact lens supplies",
        iconDrawable = R.drawable.contact_lens,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.HEALTH
    ),
    CheckItem(
        name = "Tickets(airplane, train, etc)",
        iconDrawable = R.drawable.tickets,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER
    ),
    CheckItem(
        name = "Reservations for hotel",
        iconDrawable = R.drawable.hotel_reservation,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER
    ),
    CheckItem(
        name = "Car rental",
        iconDrawable = R.drawable.car_rental,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER
    ),
    CheckItem(
        name = "A good book",
        iconDrawable = R.drawable.book,
        importanceLevel = CheckItem.ImportanceLevel.MUST,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER
    ),


    //OPTIONAL
    CheckItem(
        name = "Headphones",
        iconDrawable = R.drawable.headphones,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TECHNOLOGY
    ),
    CheckItem(
        name = "Electrical converters or travel adapters",
        iconDrawable = R.drawable.electrical_converters,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TECHNOLOGY
    ),
    CheckItem(
        name = "Camera / Video camera",
        iconDrawable = R.drawable.camera,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TECHNOLOGY
    ),
    CheckItem(
        name = "Camera Charger",
        iconDrawable = R.drawable.camera_charger,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TECHNOLOGY
    ),
    CheckItem(
        name = "Laptop or tablet",
        iconDrawable = R.drawable.laptop,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TECHNOLOGY
    ),
    CheckItem(
        name = "Laptop or tablet charger",
        iconDrawable = R.drawable.laptop_charger,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TECHNOLOGY
    ),
    CheckItem(
        name = "Portable Charger",
        iconDrawable = R.drawable.portable_charger,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TECHNOLOGY
    ),
    CheckItem(
        name = "Sunglasses",
        iconDrawable = R.drawable.sunglasses,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Watch",
        iconDrawable = R.drawable.watch,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "One casual outfit per day",
        iconDrawable = R.drawable.casual_outfit,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Sweater",
        iconDrawable = R.drawable.sweater,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Jacket",
        iconDrawable = R.drawable.jacket,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Underwear",
        iconDrawable = R.drawable.underwear,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Socks",
        iconDrawable = R.drawable.socks,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Extra shoes",
        iconDrawable = R.drawable.shoes,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Sandals",
        iconDrawable = R.drawable.sandals,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Pants",
        iconDrawable = R.drawable.pants,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Shorts",
        iconDrawable = R.drawable.shorts,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Jewelry",
        iconDrawable = R.drawable.jewelry,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Tank tops",
        iconDrawable = R.drawable.tank_tops,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Belt",
        iconDrawable = R.drawable.belt,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Pajamas",
        iconDrawable = R.drawable.pajamas,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Umbrella",
        iconDrawable = R.drawable.umbrella,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Raincoat",
        iconDrawable = R.drawable.raincoat,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Everyday bag (for carrying day items)",
        iconDrawable = R.drawable.everyday_bag,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING
    ),
    CheckItem(
        name = "Tampons or pads",
        iconDrawable = R.drawable.tampons_pad,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.WOMAN,
        category = CheckItem.Category.HEALTH
    ),
    CheckItem(
        name = "First aid kit (travel size)",
        iconDrawable = R.drawable.first_aid_kit,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.HEALTH
    ),
    CheckItem(
        name = "Toothbrush - Toothpaste",
        iconDrawable = R.drawable.toothbrush_toothpaste,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Personal care supplies",
        iconDrawable = R.drawable.personal_care,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Towel",
        iconDrawable = R.drawable.towel,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Comb / Brush",
        iconDrawable = R.drawable.comb,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Wet wipes and tissue paper",
        iconDrawable = R.drawable.wet_wipes,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Makeup",
        iconDrawable = R.drawable.makeup,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.WOMAN,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Razors",
        iconDrawable = R.drawable.razor,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Shaving cream",
        iconDrawable = R.drawable.shaving_cream,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.MAN,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "After shave",
        iconDrawable = R.drawable.after_shave,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.MAN,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Hand / Face cream",
        iconDrawable = R.drawable.hand_face_cream,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Nail clippers",
        iconDrawable = R.drawable.nail_clippers,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Parfume",
        iconDrawable = R.drawable.parfume,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Deodorant",
        iconDrawable = R.drawable.deodorant,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Shampoo - Conditioner",
        iconDrawable = R.drawable.shampoo_conditioner,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Soap",
        iconDrawable = R.drawable.soap,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Hand sanitizer",
        iconDrawable = R.drawable.hand_sanitizer,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Hairstyling products",
        iconDrawable = R.drawable.hair_spray,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.TOILETRIES
    ),
    CheckItem(
        name = "Pillow case",
        iconDrawable = R.drawable.pillow_case,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER
    ),
    CheckItem(
        name = "Laundry bag",
        iconDrawable = R.drawable.laundry_bag,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER
    ),
    CheckItem(
        name = "Toys",
        iconDrawable = R.drawable.toys,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER
    ),
    CheckItem(
        name = "Game console / Notebook",
        iconDrawable = R.drawable.game_console,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER
    ),
    CheckItem(
        name = "Board Games",
        iconDrawable = R.drawable.board_game,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER
    ),
    CheckItem(
        name = "Snacks",
        iconDrawable = R.drawable.snack,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER
    )
)

val summerVacationCheckItems = listOf(

    //OPTIONAL
    CheckItem(
        name = "Swimwear",
        iconDrawable = R.drawable.swimwear,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING,
        vacationType = CheckItem.VacationType.SUMMER_VACATION
    ),
    CheckItem(
        name = "Beach Towel",
        iconDrawable = R.drawable.beach_towel,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING,
        vacationType = CheckItem.VacationType.SUMMER_VACATION
    ),
    CheckItem(
        name = "Summer Hat",
        iconDrawable = R.drawable.sun_hat,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING,
        vacationType = CheckItem.VacationType.SUMMER_VACATION
    ),
    CheckItem(
        name = "Water Shoes",
        iconDrawable = R.drawable.water_shoe,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SUMMER_VACATION
    ),
    CheckItem(
        name = "Snorkel",
        iconDrawable = R.drawable.snorkel,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SUMMER_VACATION
    ),
    CheckItem(
        name = "Beach Umbrella",
        iconDrawable = R.drawable.beach_umbrella,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SUMMER_VACATION
    ),
    CheckItem(
        name = "Beach Foldable Chair",
        iconDrawable = R.drawable.beach_chair,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SUMMER_VACATION
    ),
    CheckItem(
        name = "Frisbees, beach balls etc",
        iconDrawable = R.drawable.beach_ball,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SUMMER_VACATION
    ),
)

val skiTripCheckItems = listOf(

    //OPTIONAL
    CheckItem(
        name = "Heavy Coat or Parka",
        iconDrawable = R.drawable.heavy_coat,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "All-Weather Boots",
        iconDrawable = R.drawable.all_weather_boots,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "Insulated Leather Gloves or Mittens",
        iconDrawable = R.drawable.leather_gloves,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "Insulated Hat",
        iconDrawable = R.drawable.winter_hat,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "Scarf",
        iconDrawable = R.drawable.scarf,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "Balaclava",
        iconDrawable = R.drawable.balaclava,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.CLOTHING,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "Ski-Board Equipments",
        iconDrawable = R.drawable.ski_board_equipments,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "Ski-Board Helmet",
        iconDrawable = R.drawable.ski_board_helmet,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "Ski-Board Glasses",
        iconDrawable = R.drawable.ski_board_glasses,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "Ski-Board Jacket",
        iconDrawable = R.drawable.ski_board_jacket,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "Ski-Board Pants",
        iconDrawable = R.drawable.ski_board_pants,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "Ski-Board Socks",
        iconDrawable = R.drawable.ski_board_socks,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "Ski-Board Boots",
        iconDrawable = R.drawable.ski_board_boots,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SKI_TRIP
    ),
    CheckItem(
        name = "Ski-Board Gloves",
        iconDrawable = R.drawable.ski_board_gloves,
        importanceLevel = CheckItem.ImportanceLevel.OPTIONAL,
        gender = CheckItem.Gender.UNISEX,
        category = CheckItem.Category.OTHER,
        vacationType = CheckItem.VacationType.SKI_TRIP
    )
)













