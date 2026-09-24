package com.github.yttrium364.workflow_kmp_portfolio_site.domain

enum class LabId {
    Unscramble,
    Dice,
}
data class LabEntry(val id: LabId, val title: String, val level: String, val brief: String)
