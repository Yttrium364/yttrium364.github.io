package com.github.yttrium364.workflow_kmp_portfolio_site.domain

sealed interface HangState {
    data class Playing(
        val secret: String,
        val guessed: Set<Char>,
        val misses: Int,
    ) : HangState

    data class Won(val secret: String) : HangState
    data class Lost(val secret: String) : HangState
}