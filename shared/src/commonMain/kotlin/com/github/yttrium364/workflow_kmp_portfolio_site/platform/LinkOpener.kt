package com.github.yttrium364.workflow_kmp_portfolio_site.platform

interface LinkOpener {
    fun open(url: String)
}

expect fun createLinkOpener(): LinkOpener

fun LinkOpener.openCatching(url: String) {
    runCatching { open(url) }
}