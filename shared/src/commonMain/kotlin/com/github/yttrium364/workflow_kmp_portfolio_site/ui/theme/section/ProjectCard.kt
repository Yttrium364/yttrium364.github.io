package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.Project


@Composable
fun ProjectCard(
    project: Project,
    onOpen: () -> Unit
) {
    Surface(
        modifier = Modifier.clickable { onOpen() }.padding(4.dp),
        color = MaterialTheme.colorScheme.surface,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = project.title,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = project.short,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}