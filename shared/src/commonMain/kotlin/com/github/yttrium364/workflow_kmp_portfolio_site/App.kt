package com.github.yttrium364.workflow_kmp_portfolio_site

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.ColorTokens
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.PortfolioTheme

@Composable
fun App() {
    PortfolioTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
        ) {
            Text(
                text = "kmp-portfolio",
                color = ColorTokens.navy,
            )
        }
    }
}