package tech.vodafone.githuprepoviewer.presentation.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF282828),
    primaryContainer = Color(0xFF7B7B7B),
    onPrimary = Color(0xFFF5F5F5),

    secondary = Color(0xFF595959),
    secondaryContainer = Color(0xFF595959),
    onSecondary = Color(0xFFD9D4D4),

    background = Color(0xFF000000),
    onBackground = Color(0xFFF6F6F6),

    surface = Color(0xFF000000),
    onSurface = Color(0xFFF6F6F6),

    error = Color(0xFFE50606),
    onError = Color(0xFFFFFFFF),

    )

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF096FFA),
    primaryContainer = Color(0xFF63B5F8),
    onPrimary = Color(0xFFF5F5F5),

    secondary = Color(0xFFE7F2F8),
    secondaryContainer = Color(0xFFE7F2F8),
    onSecondary = Color(0xFF262525),

    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF090808),

    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF6D787A),

    error = Color(0xFFE50606),
    onError = Color(0xFFFFFFFF),

    )


@Composable
fun GithupRepoViewerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
