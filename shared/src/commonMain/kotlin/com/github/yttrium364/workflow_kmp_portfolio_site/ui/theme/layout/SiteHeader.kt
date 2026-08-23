package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.LocalCopy

@Composable
fun SiteHeader() {
    Row(Modifier.fillMaxWidth().padding(16.dp, 8.dp)) {
        Text(LocalCopy.current.role)
    }
}
