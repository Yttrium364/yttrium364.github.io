package com.github.yttrium364.workflow_kmp_portfolio_site.domain

enum class KmpScope {
    Desktop,
    Web,
    Shared,
}

data class KmpPoint(
    val title: String,
    val line: String,
    val scopes: Set<KmpScope>,
)

fun List<KmpPoint>.forScope(scope: KmpScope?): List<KmpPoint> {
    if (scope == null) return this
    return filter { point -> point.scopes.contains(scope) }
}