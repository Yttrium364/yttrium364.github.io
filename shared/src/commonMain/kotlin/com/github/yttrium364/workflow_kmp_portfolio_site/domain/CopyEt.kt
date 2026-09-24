package com.github.yttrium364.workflow_kmp_portfolio_site.domain

fun copyEt() = LocalizedCopy(
    role = "Multiplatvormi arendaja",
    tagline = "Kotlin, jagatud kasutajaliides, Desktop ja Web — minu lemmiktööriistad arenduseks.",
    aboutHeading = "Minust",
    about = "Keskendun efektiivsete lahenduste loomisele kaasaegsete platvormiüleste tehnoloogiate abil.",
    why = "Kotlin Multiplatform võimaldab maksimaalselt koodi jagada, säilitades täieliku kontrolli jõudluse üle.",
    repo = "Vaata minu repositooriume ja põhiteeke allpool.",
    kmpHeading = "KMP Supervõimed",
    projectsHeading = "Esiletõstetud Projektid",
    projectsCta = "Vaata Projekte",
    liveHeading = "Live-laborid",
    liveCta = "Vaata Otseülekannet",
    check = "Kontrolli",
    newLetters = "Uued tähed",
    start = "Alusta",
    github = "GitHub",
    labs = listOf(
        LabEntry(
            id = LabId.Unscramble,
            title = "Unscramble",
            level = "Algaja",
            brief = "Jagatud Compose UI-ga sõnamängu labor."
        ),
        LabEntry(
            id = LabId.Dice,
            title = "Täringud",
            level = "Algaja",
            brief = "Veereta kahte täringut ja vaata, kes võidab."
        )
    )
)
