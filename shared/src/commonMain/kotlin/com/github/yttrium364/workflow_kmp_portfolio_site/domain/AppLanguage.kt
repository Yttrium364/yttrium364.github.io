package com.github.yttrium364.workflow_kmp_portfolio_site.domain

enum class AppLanguage {
    English,
    RU,
    ET
}

fun AppLanguage.next(): AppLanguage =
    AppLanguage.entries[(ordinal + 1) % AppLanguage.entries.size] //
fun AppLanguage.label(): String = when (this) {
    AppLanguage.English -> "English"
    AppLanguage.RU -> "Русский"
    AppLanguage.ET -> "Eesti"
}