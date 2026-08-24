package com.github.yttrium364.workflow_kmp_portfolio_site

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.copyEn
import com.github.yttrium364.workflow_kmp_portfolio_site.platform.screenWidthDp
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.ColorTokens
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.LocalCopy
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.PortfolioTheme
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.layout.SiteHeader

@Composable
fun App() {
    CompositionLocalProvider(LocalCopy provides copyEn()) {

        PortfolioTheme {

            Box(
                modifier = Modifier.padding(top = 72.dp)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
            ) {
                SiteHeader()
                LazyColumn(modifier = Modifier.fillMaxSize())
                {
                    item {
                        Text(LocalCopy.current.tagline)
                        Text("Hero", color = MaterialTheme.colorScheme.onBackground)
                        Text("${screenWidthDp()}", color = MaterialTheme.colorScheme.onBackground)
                        Column(modifier = Modifier.fillMaxWidth().widthIn(max = 1200.dp).padding(24.dp)) {
                        }
                    }
                }


            }
        }

    }
}