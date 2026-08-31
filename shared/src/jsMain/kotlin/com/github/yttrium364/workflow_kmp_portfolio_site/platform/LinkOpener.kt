package com.github.yttrium364.workflow_kmp_portfolio_site.platform

import web.window.window

private class JsLinkOpener : LinkOpener {
    override fun open(url: String) {
        window.open(url)
    }
}

actual fun createLinkOpener(): LinkOpener = JsLinkOpener()