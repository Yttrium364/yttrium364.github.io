package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.SiteContent
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.LocalCopy


@Composable
fun HeroLinks(
    onProjects: () -> Unit,
    onLive: () -> Unit,
    onOpenUrl: (String) -> Unit,
) {
    val copy = LocalCopy.current
    val github = SiteContent.social.firstOrNull { it.label == "GitHub" }

    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedButton(onClick = onProjects) {
            Text(text = copy.projectsCta)
        }
        OutlinedButton(onClick = onLive) {
            Text(text = copy.liveCta)
        }
        if (github != null) {
            Button(onClick = { onOpenUrl(github.url) }) {
                Text(text = copy.github)
            }
        }
    }
}