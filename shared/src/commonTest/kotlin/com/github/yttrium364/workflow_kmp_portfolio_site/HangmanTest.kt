package com.github.yttrium364.workflow_kmp_portfolio_site


import com.github.yttrium364.workflow_kmp_portfolio_site.domain.HangState
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class HangmanTest {
    @Test
    fun hitThenWin() {
        val start = Hangman.start("AB")
        assertEquals("_ _", Hangman.mask(start))
        val a = Hangman.guess(start, 'A')
        assertIs<HangState.Playing>(a)
        assertEquals("A _", Hangman.mask(a))
    }
}