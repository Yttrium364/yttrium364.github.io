package com.github.yttrium364.workflow_kmp_portfolio_site

import com.github.yttrium364.workflow_kmp_portfolio_site.domain.GuessHint
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.GuessState

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class GuessGameTest {
    @Test
    fun lowThenHighThenWin() {
        val start = GuessGame.start(10)
        val low = GuessGame.guess(start, 3)
        assertIs<GuessState.Playing>(low)
        assertEquals(GuessHint.Low, low.lastHint)
    }
}
