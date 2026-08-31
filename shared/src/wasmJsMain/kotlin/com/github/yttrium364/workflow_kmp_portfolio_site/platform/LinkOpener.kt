package com.github.yttrium364.workflow_kmp_portfolio_site.platform

import kotlinx.browser.window

private class WasmLinkOpener : LinkOpener {
    override fun open(url: String) {
        window.open(url)
    }
}

actual fun createLinkOpener(): LinkOpener = WasmLinkOpener()