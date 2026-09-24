package com.github.yttrium364.workflow_kmp_portfolio_site

import com.github.yttrium364.workflow_kmp_portfolio_site.domain.DiceRoll
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.DiceWinner
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.winner
import kotlin.test.Test
import kotlin.test.assertEquals

class DiceTest {
    @Test
    fun winnerBranches() {
        assertEquals(DiceWinner.First, DiceRoll(6, 1).winner())
        assertEquals(DiceWinner.Second, DiceRoll(2, 5).winner())
        assertEquals(DiceWinner.Tie, DiceRoll(3, 3).winner())
    }
}
