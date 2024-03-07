package tech.vodafone.githuprepoviewer.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import tech.vodafone.githuprepoviewer.R

private val cairo = FontFamily(
    Font(R.font.cairo_light, FontWeight.Light),
    Font(R.font.cairo_bold, FontWeight.Bold),
    Font(R.font.cairo_extrabold, FontWeight.ExtraBold),
    Font(R.font.cairo_extralight, FontWeight.ExtraLight),
    Font(R.font.cairo_black, FontWeight.Black),
    Font(R.font.cairo_medium, FontWeight.Medium),
    Font(R.font.cairo_semibold, FontWeight.SemiBold),
    Font(R.font.cairo_regular, FontWeight.Normal),
)

private val defaultTypography = Typography()

val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = cairo),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = cairo),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = cairo),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = cairo),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = cairo),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = cairo),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = cairo),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = cairo),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = cairo),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = cairo),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = cairo),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = cairo),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = cairo),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = cairo),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = cairo)

)