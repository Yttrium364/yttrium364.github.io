package com.github.yttrium364.workflow_kmp_portfolio_site.domain

data class KmpChipItem(val scope: KmpScope?) {
    fun chip(): String = scope?.name ?: "All"
}

object SiteContent {
    val headerNav = listOf(SectionId.Why, SectionId.Kmp, SectionId.Projects, SectionId.Live)

    val social = listOf(
        SocialLink(label = "GitHub", url = "https://github.com")
    )

    val tech = listOf("Kotlin", "Compose Multiplatform", "Coroutines")

    val kmpChips = listOf(
        KmpChipItem(null),
        KmpChipItem(KmpScope.Shared),
        KmpChipItem(KmpScope.Desktop),
        KmpChipItem(KmpScope.Web)
    )

    val kmpPoints = listOf(
        KmpPoint("Shared Logic", "Write once, run everywhere seamlessly.", setOf(KmpScope.Shared)),
        KmpPoint("Native UI Speed", "Hardware accelerated interface components.", setOf(KmpScope.Desktop, KmpScope.Web)),
        KmpPoint("Wasm Support", "WebAssembly target for high performance web.", setOf(KmpScope.Web))
    )

    val projects = listOf(
        Project(
            title = "KMP Portfolio",
            short = "This website built with Kotlin Multiplatform",
            tags = setOf("Kotlin", "Compose", "Wasm"),
            role = "Creator",
            status = ProjectStatus.Active,
            href = "https://github.com"
        ),
        Project(
            title = "Second App",
            short = "A beautiful cross-platform desktop client",
            tags = setOf("Kotlin", "Compose Desktop"),
            role = "Developer",
            status = ProjectStatus.Completed,
            href = "https://github.com"
        )
    )
}
