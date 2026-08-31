package com.github.yttrium364.workflow_kmp_portfolio_site.platform

import java.awt.Desktop
import java.net.URI

class JvmLinkOpener : LinkOpener {
    override fun open(url: String) {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(URI(url))
        }
    }
}

actual fun createLinkOpener(): LinkOpener = JvmLinkOpener()