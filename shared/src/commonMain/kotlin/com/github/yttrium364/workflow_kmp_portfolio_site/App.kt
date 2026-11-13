package com.github.yttrium364.workflow_kmp_portfolio_site

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.withFrameNanos
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
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
import com.github.yttrium364.workflow_kmp_portfolio_site.platform.isCompactWidth
import com.github.yttrium364.workflow_kmp_portfolio_site.platform.screenWidthDp
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.AppColorTheme
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.LocalCopy
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.PortfolioTheme
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.layout.SiteHeader
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.layout.SectionOrder
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.layout.SectionScroller
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.HeroSection
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.HangmanPage
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.DicePage
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.KmpSection
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.LiveSection
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.ProjectsSection
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.UnscramblePage
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section.WhySection
import kotlinx.coroutines.launch



@Composable
fun App() {

        var colorTheme by remember { mutableStateOf(AppColorTheme.Navy) }
        var language by remember { mutableStateOf(AppLanguage.English) }
        var openLab by remember { mutableStateOf<LabId?>(null) }
        val opener = remember { createLinkOpener() }
        val listState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()
        val snapFling = rememberSnapFlingBehavior(lazyListState = listState)
        val scroller = remember(listState, coroutineScope) {
            SectionScroller(
                listState = listState,
                indexOf = { id -> SectionOrder.indexOf(id).coerceAtLeast(0) },
                scope = coroutineScope,
            )
        }
        val compact = isCompactWidth(screenWidthDp())

        fun closeLab() {
            openLab = null
        }

        fun navigateToSection(id: SectionId) {
            val returningFromLab = openLab != null
            closeLab()
            if (returningFromLab) {
                coroutineScope.launch {
                    withFrameNanos { }
                    scroller.go(id)
                }
            } else {
                scroller.go(id)
            }
        }

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
                                modifier = Modifier.fillMaxSize(),
                                state = listState,
                                flingBehavior = snapFling,
                            ) {
                                item(SectionId.Hero) {
                                    HeroSection(
                                        modifier = Modifier.fillParentMaxSize(),
                                        onOpenUrl = { opener.openCatching(it) },
                                        onProjects = { scroller.go(SectionId.Projects) },
                                        onLive = { scroller.go(SectionId.Live) },
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
                            when (openLab) {
                                LabId.Unscramble -> UnscramblePage()
                                LabId.Dice -> DicePage()
                                LabId.Hangman -> HangmanPage()
                                null -> Unit
                            }
                        }
                    }

                    SiteHeader(
                        language = language,
                        onLanguageChange = { language = it },
                        theme = colorTheme,
                        onThemeChange = { colorTheme = it },
                        onBack = if (openLab != null) ({
                            navigateToSection(SectionId.Live)
                        }) else null,
                        compact = compact,
                        onNavigate = { id -> navigateToSection(id) },
                    )
                }
            }
        }
    }
