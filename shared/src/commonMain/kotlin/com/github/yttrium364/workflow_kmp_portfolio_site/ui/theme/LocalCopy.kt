package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.copyEn
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.LocalizedCopy


val LocalCopy = staticCompositionLocalOf<LocalizedCopy> {
    copyEn()
}