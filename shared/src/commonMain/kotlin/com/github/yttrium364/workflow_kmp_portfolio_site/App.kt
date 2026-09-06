package com.github.yttrium364.workflow_kmp_portfolio_site

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.AppLanguage
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.LabId
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.SectionId
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.localizedCopy
import com.github.yttrium364.workflow_kmp_portfolio_site.platform.createLinkOpener
import com.github.yttrium364.workflow_kmp_portfolio_site.platform.openCatching
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.AppColorTheme
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.LocalCopy
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.PortfolioTheme
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.layout.SiteHeader
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.HeroSection
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.KmpSection
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.LiveSection
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.ProjectsSection
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.UnscramblePage
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.WhySection



@Composable
fun App() {
    var colorTheme by remember { mutableStateOf(AppColorTheme.Navy) }
    var language by remember { mutableStateOf(AppLanguage.English) }
    var openLab by remember { mutableStateOf<LabId?>(null) }
    val opener = remember { createLinkOpener() }

    PortfolioTheme(theme = colorTheme) {
        CompositionLocalProvider(value = LocalCopy provides language.localizedCopy()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopCenter,
                ) {
                    if (openLab == null) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            item(SectionId.Hero) {
                                HeroSection(
                                    modifier = Modifier.fillParentMaxSize(),
                                    onOpenUrl = { opener.openCatching(it) }
                                )
                            }
                            item(SectionId.Why) {
                                WhySection(
                                    modifier = Modifier.fillParentMaxSize()
                                )
                            }
                            item(SectionId.Kmp) {
                                KmpSection(
                                    modifier = Modifier.fillParentMaxSize()
                                )
                            }
                            item(SectionId.Projects) {
                                ProjectsSection(
                                    onOpenProject = { opener.openCatching(it) },
                                    modifier = Modifier.fillParentMaxSize()
                                )
                            }
                            item(SectionId.Live) {
                                LiveSection(
                                    onOpenLab = { id -> openLab = id },
                                    modifier = Modifier.fillParentMaxSize(),
                                )
                            }
                        }
                    } else {
                        UnscramblePage()
                    }
                }

                SiteHeader(
                    language = language,
                    onLanguageChange = { language = it },
                    theme = colorTheme,
                    onThemeChange = { colorTheme = it }
                )
            }
        }
    }
}
