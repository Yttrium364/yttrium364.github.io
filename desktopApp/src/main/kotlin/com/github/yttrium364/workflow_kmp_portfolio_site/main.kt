package com.github.yttrium364.workflow_kmp_portfolio_site

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "workflow_kmp_portfolio_site",
    ) {
        App()
    }
}