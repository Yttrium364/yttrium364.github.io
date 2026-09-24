package com.github.yttrium364.workflow_kmp_portfolio_site.domain

enum class DiceWinner {
    First,
    Second,
    Tie,
}

data class DiceRoll(
    val first: Int,
    val second: Int,
)

fun DiceRoll.winner(): DiceWinner = when {
    first > second -> DiceWinner.First
    second > first -> DiceWinner.Second
    else -> DiceWinner.Tie
}
