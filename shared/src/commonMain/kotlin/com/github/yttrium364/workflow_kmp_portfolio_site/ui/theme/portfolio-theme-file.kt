package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

@Composable
fun PortfolioTheme(content: @Composable () -> Unit) {
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