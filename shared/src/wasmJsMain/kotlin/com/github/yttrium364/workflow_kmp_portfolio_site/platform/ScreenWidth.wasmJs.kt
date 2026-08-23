package com.github.yttrium364.workflow_kmp_portfolio_site.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo

@Composable
actual fun screenWidthDp(): Int {
    val container = LocalWindowInfo.current.containerSize
    return with(LocalDensity.current) { container.width.toDp().value.toInt() }
}