package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

enum class AppColorTheme {
    Navy;

    fun next(): AppColorTheme {
        val values = entries
        val nextIndex = (ordinal + 1) % values.size
        return values[nextIndex]
    }

    fun label(): String = when (this) {
        Navy -> "Navy"
    }
}

@Composable
fun PortfolioTheme(
    theme: AppColorTheme = AppColorTheme.Navy,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = ColorTokens.mint,
            onPrimary = ColorTokens.navy,
            background = ColorTokens.navy,
            onBackground = ColorTokens.nearWhite,
            surface = ColorTokens.navyAccent,
            onSurface = ColorTokens.nearWhite,
            onSurfaceVariant = ColorTokens.slate,
        ),
        content = content,
    )
}