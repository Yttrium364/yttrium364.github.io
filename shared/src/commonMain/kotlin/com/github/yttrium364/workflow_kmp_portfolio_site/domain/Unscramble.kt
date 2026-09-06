package com.github.yttrium364.workflow_kmp_portfolio_site.domain

fun scramble(word: String): String {
    if (word.length <= 1) return word
    var mixed: String
    do {
        mixed = word.toList().shuffled().joinToString("")
    } while (mixed == word)
    return mixed
}

data class UnscrambleRound(
    val secret: String,
    val mixed: String,
)

object UnscrambleBank {
    private val words = listOf("compose", "kotlin", "shared", "desktop", "browser")

    fun nextRound(previousSecret: String? = null): UnscrambleRound {
        val candidates = words.filterNot { it == previousSecret }.ifEmpty { words }
        val secret = candidates.random()
        return UnscrambleRound(
            secret = secret,
            mixed = scramble(secret)
        )
    }

    fun matches(secret: String, answer: String): Boolean =
        secret.equals(answer.trim(), ignoreCase = true)
}
