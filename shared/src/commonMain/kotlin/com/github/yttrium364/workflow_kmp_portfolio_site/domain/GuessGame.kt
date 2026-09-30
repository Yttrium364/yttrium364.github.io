package com.github.yttrium364.workflow_kmp_portfolio_site.domain

sealed interface GuessState {
    data class Playing(
        val secret: Int,
        val tries: Int,
        val lastHint: GuessHint?,
    ) : GuessState
    data class Won(val tries: Int) : GuessState
}

enum class GuessHint {
    Low,
    High,
}