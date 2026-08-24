package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.LocalCopy


@Composable
fun HeroSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 72.dp),
        contentAlignment = Alignment.Center
    ) {
        val copy = LocalCopy.current

        Column(
            modifier = Modifier.widthIn(max = 800.dp)
        ) {
            Text(
                text = copy.role,
                fontSize = 48.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = copy.tagline,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}