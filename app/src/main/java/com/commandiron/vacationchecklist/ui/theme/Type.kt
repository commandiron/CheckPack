package com.commandiron.vacationchecklist.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.commandiron.vacationchecklist.R

val Poppins = FontFamily(
    Font(R.font.poppins_black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.poppins_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.poppins_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.poppins_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.poppins_extra_bold, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.poppins_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.poppins_extra_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.poppins_extra_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.poppins_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.poppins_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.poppins_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.poppins_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.poppins_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.poppins_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.poppins_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.poppins_thin, FontWeight.Thin, FontStyle.Normal),
    Font(R.font.poppins_thin_italic, FontWeight.Thin, FontStyle.Italic),
)

val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = Poppins,
        fontSize = 30.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Poppins,
        fontSize = 28.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Poppins,
        fontSize = 26.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Poppins,
        fontSize = 24.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Poppins,
        fontSize = 22.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Poppins,
        fontSize = 20.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Poppins,
        fontSize = 18.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Poppins,
        fontSize = 16.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Poppins,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Poppins,
        fontSize = 12.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Poppins,
        fontSize = 10.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Poppins,
        fontSize = 8.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Poppins,
        fontSize = 6.sp
    )
)