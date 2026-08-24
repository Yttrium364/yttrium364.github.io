package com.github.yttrium364.workflow_kmp_portfolio_site

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.AppLanguage
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.localizedCopy
import com.github.yttrium364.workflow_kmp_portfolio_site.platform.screenWidthDp
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.AppColorTheme
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.LocalCopy
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.PortfolioTheme
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.layout.SiteHeader


@Composable
fun App() {
    var language by remember { mutableStateOf(AppLanguage.English) }
    var colorTheme by remember { mutableStateOf(AppColorTheme.Navy) }

    PortfolioTheme(theme = colorTheme) {
        CompositionLocalProvider(LocalCopy provides language.localizedCopy()) {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.TopCenter,
            ) {
                val w = "width = ${screenWidthDp()}"

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .widthIn(max = 1200.dp)
                                .padding(24.dp)
                        ) {
                            Text(
                                text = w,
                                color = MaterialTheme.colorScheme.primary,
                            )

                            SiteHeader(
                                language = language,
                                onLanguageChange = { language = it },
                                colorTheme = colorTheme,
                                onThemeChange = { colorTheme = it }
                            )

                            Text(
                                text = LocalCopy.current.tagline,
                                modifier = Modifier.padding(top = 72.dp),
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                        }
                    }
                }
            }
        }
    }
}