package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.LabId
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.LocalCopy



@Composable
fun LiveSection(
    onOpenLab: (LabId) -> Unit,
    modifier: Modifier = Modifier
) {
    val copy = LocalCopy.current
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = copy.liveHeading,
            style = MaterialTheme.typography.headlineMedium
        )


        copy.labs.forEach { lab ->
            Button(
                onClick = { onOpenLab(lab.id) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "${lab.title} · ${lab.level}")
            }
        }
    }
}

@Composable
fun LabDetailSection(
    labId: LabId?,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val copy = LocalCopy.current
    val lab = copy.labs.firstOrNull { it.id == labId }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = lab?.title ?: copy.liveHeading,
                style = MaterialTheme.typography.headlineMedium
            )
            lab?.let {
                Text(
                    text = it.brief,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = it.level,
                    style = MaterialTheme.typography.labelLarge
                )
            }
            Button(onClick = onBack) {
                Text("Back")
            }
        }
    }
}
