package com.github.yttrium364.workflow_kmp_portfolio_site

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.ColorTokens
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.PortfolioTheme

@Composable
fun App() {
    PortfolioTheme {
        Text(
            text = "kmp-portfolio",
            color = ColorTokens.navy,
        )
    }
}