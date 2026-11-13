package com.github.yttrium364.workflow_kmp_portfolio_site

import com.github.yttrium364.workflow_kmp_portfolio_site.domain.GuessHint
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.GuessState
import kotlin.random.Random

object GuessGame {
    const val min = 1
    const val max = 10

    fun start(secret: Int = Random.nextInt(min, max + 1)): GuessState.Playing {
        require(secret in min..max) { "Secret must be between $min and $max" }
        return GuessState.Playing(secret = secret, tries = 0, lastHint = null)
    }

    fun guess(state: GuessState, value: Int): GuessState {
        if (state !is GuessState.Playing || value !in min..max) return state
        val tries = state.tries + 1
        return when {
            value == state.secret -> GuessState.Won(tries)
            value < state.secret -> state.copy(tries = tries, lastHint = GuessHint.Low)
            else -> state.copy(tries = tries, lastHint = GuessHint.High)
        }
    }
}
