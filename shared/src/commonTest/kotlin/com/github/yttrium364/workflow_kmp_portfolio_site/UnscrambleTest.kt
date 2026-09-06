package com.github.yttrium364.workflow_kmp_portfolio_site

import com.github.yttrium364.workflow_kmp_portfolio_site.domain.UnscrambleBank
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UnscrambleTest {
    @Test
    fun matchesIgnoresCaseAndTrim() {
        assertTrue(UnscrambleBank.matches("tea", "TEA"))
        assertTrue(UnscrambleBank.matches("tea", " tea "))
        assertFalse(UnscrambleBank.matches("tea", "cat"))
    }
}
