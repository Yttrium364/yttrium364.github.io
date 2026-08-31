package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.SiteContent
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.LocalCopy


@Composable
fun ProjectsSection(
    onOpenProject: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val copy = LocalCopy.current
    val projects = SiteContent.projects

    Box(
        modifier = modifier.fillMaxSize().padding(top = 72.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 1200.dp)
                .padding(24.dp)
        ) {
            Text(
                text = copy.projectsHeading,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Row {
                projects.forEach { project ->
                    ProjectCard(
                        project = project,
                        onOpen = { onOpenProject(project.href) }
                    )
                }
            }
        }
    }
}