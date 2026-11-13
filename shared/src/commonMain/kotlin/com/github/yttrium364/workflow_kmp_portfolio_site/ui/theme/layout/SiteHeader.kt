package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.AppLanguage
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.LocalizedCopy
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.SectionId
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.SiteContent
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.label
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.next
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.AppColorTheme
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.LocalCopy

@Composable
fun SiteHeader(
    language: AppLanguage,
    onLanguageChange: (AppLanguage) -> Unit,
    theme: AppColorTheme,
    onThemeChange: (AppColorTheme) -> Unit,
    onBack: (() -> Unit)? = null,
    compact: Boolean = false,
    onNavigate: ((SectionId) -> Unit)? = null,
) {
    val copy = LocalCopy.current
    var menuOpen by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        if (onBack != null) {
            TextButton(onClick = onBack) {
                Text(copy.back)
            }
        }
        if (onNavigate != null) {
            if (compact) {
                androidx.compose.foundation.layout.Box {
                    TextButton(onClick = { menuOpen = true }) {
                        Text(copy.menu)
                    }
                    DropdownMenu(
                        expanded = menuOpen,
                        onDismissRequest = { menuOpen = false },
                    ) {
                        SiteContent.headerNav.forEach { id ->
                            DropdownMenuItem(
                                text = { Text(id.navLabel(copy)) },
                                onClick = {
                                    menuOpen = false
                                    onNavigate(id)
                                },
                            )
                        }
                    }
                }
            } else {
                SiteContent.headerNav.forEach { id ->
                    TextButton(onClick = { onNavigate(id) }) {
                        Text(id.navLabel(copy))
                    }
                }
            }
        }
        Text(
            text = copy.role,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.weight(1f)
        )
        TextButton(onClick = { onLanguageChange(language.next()) }) {
            Text(language.label())
        }
        TextButton(onClick = { onThemeChange(theme.next()) }) {
            Text(theme.label())
        }
    }
}

fun SectionId.navLabel(copy: LocalizedCopy): String = when (this) {
    SectionId.Why -> copy.navAbout
    SectionId.Kmp -> copy.navKmp
    SectionId.Projects -> copy.navProjects
    SectionId.Live -> copy.navLive
    SectionId.Hero -> copy.role
}
