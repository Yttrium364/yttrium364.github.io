package com.github.yttrium364.workflow_kmp_portfolio_site

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform