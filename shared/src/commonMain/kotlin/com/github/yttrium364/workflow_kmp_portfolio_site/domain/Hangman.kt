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

object Hangman {
    const val maxMisses = 6

    fun start(secret: String): HangState.Playing {
        require(secret.isNotBlank()) { "Secret word must not be blank" }
        require(secret.all { it.isLetter() }) { "Secret word must contain only letters" }
        return HangState.Playing(secret.uppercase(), emptySet(), 0)
    }

    fun guess(state: HangState, letter: Char): HangState {
        if (state !is HangState.Playing) return state
        val normalized = letter.uppercaseChar()
        if (!normalized.isLetter() || normalized in state.guessed) return state
        val guessed = state.guessed + normalized
        if (state.secret.all { it in guessed }) return HangState.Won(state.secret)
        val misses = state.misses + if (normalized in state.secret) 0 else 1
        return if (misses >= maxMisses) HangState.Lost(state.secret)
        else state.copy(guessed = guessed, misses = misses)
    }

    fun mask(state: HangState): String = when (state) {
        is HangState.Playing -> state.secret.map { if (it in state.guessed) it else '_' }.joinToString(" ")
        is HangState.Won -> state.secret.toCharArray().joinToString(" ")
        is HangState.Lost -> state.secret.toCharArray().joinToString(" ")
    }
}
