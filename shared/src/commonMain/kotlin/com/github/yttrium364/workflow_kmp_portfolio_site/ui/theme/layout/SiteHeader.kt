package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.AppLanguage
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.label
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.next
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.AppColorTheme
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.LocalCopy

@Composable
fun SiteHeader(
    language: AppLanguage,
    onLanguageChange: (AppLanguage) -> Unit,
    colorTheme: AppColorTheme,
    onThemeChange: (AppColorTheme) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = LocalCopy.current.role,
            color = MaterialTheme.colorScheme.onBackground,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            TextButton(onClick = { onLanguageChange(language.next()) }) {
                Text(text = language.label())
            }

            TextButton(onClick = { onThemeChange(colorTheme.next()) }) {
                Text(text = colorTheme.label())
            }
        }
    }
}