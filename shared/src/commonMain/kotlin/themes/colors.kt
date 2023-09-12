package themes

import androidx.compose.ui.graphics.Color

data class AppColors(
    val templateBackgroundColor: Color,
)

val lightPaletteTheme = AppColors(
    templateBackgroundColor = Color(0xFFfdfcf7),
)

val darkPaletteTheme = AppColors(
    templateBackgroundColor = Color(0xFF1E1E1E),
)