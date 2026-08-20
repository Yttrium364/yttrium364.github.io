package com.github.yttrium364.workflow_kmp_portfolio_site

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return sayHello(platform.name)
    }
}