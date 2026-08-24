package com.github.yttrium364.workflow_kmp_portfolio_site.domain


enum class AppLanguage {
    English,
    Russian,
    Estonian;

}

fun AppLanguage.next(): AppLanguage {
    return when (this) {
        AppLanguage.English -> AppLanguage.Russian
        AppLanguage.Russian -> AppLanguage.Estonian
        AppLanguage.Estonian -> AppLanguage.English
    }
}

fun AppLanguage.label(): String {
    return when (this) {
        AppLanguage.English -> "EN"
        AppLanguage.Russian -> "RU"
        AppLanguage.Estonian -> "ET"
    }
}

fun AppLanguage.localizedCopy(): LocalizedCopy {
    return when (this) {
        AppLanguage.English -> copyEn()
        AppLanguage.Russian -> copyRu()
        AppLanguage.Estonian -> copyEt()
    }
}