package net.thunderbird.components.ui.bolt.theme

import android.os.Build
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
internal actual fun platformColorScheme(
    defaultColorScheme: ThemeColorScheme,
    darkTheme: Boolean,
    useDynamicColors: Boolean,
): ThemeColorScheme {
    if (!useDynamicColors || Build.VERSION.SDK_INT < Build.VERSION_CODES.S) return defaultColorScheme

    val context = LocalContext.current
    val dynamicColorScheme = if (darkTheme) {
        dynamicDarkColorScheme(context)
    } else {
        dynamicLightColorScheme(context)
    }

    return dynamicColorScheme.toBoltColorScheme(defaultColorScheme)
}

private fun ColorScheme.toBoltColorScheme(fallback: ThemeColorScheme) = fallback.copy(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,
    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = tertiaryContainer,
    onTertiaryContainer = onTertiaryContainer,
    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,
    surfaceDim = surfaceDim,
    surface = surface,
    surfaceBright = surfaceBright,
    onSurface = onSurface,
    onSurfaceVariant = onSurfaceVariant,
    surfaceContainerLowest = surfaceContainerLowest,
    surfaceContainerLow = surfaceContainerLow,
    surfaceContainer = surfaceContainer,
    surfaceContainerHigh = surfaceContainerHigh,
    surfaceContainerHighest = surfaceContainerHighest,
    inverseSurface = inverseSurface,
    inverseOnSurface = inverseOnSurface,
    inversePrimary = inversePrimary,
    outline = outline,
    outlineVariant = outlineVariant,
    scrim = scrim,
)
