package com.github.yttrium364.workflow_kmp_portfolio_site.domain

fun copyEn() = LocalizedCopy(
    role = "Multiplatform developer",
    tagline = "Kotlin, shared UI, Desktop and Web — what I like to build with.",
    aboutHeading = "About me",
    about = "I focus on engineering efficient experiences using modern cross-platform technologies.",
    why = "Kotlin Multiplatform allows maximizing code sharing while retaining full control over performance.",
    repo = "Check out my repositories and core libraries below.",
    kmpHeading = "KMP Superpowers",
    projectsHeading = "Featured Projects",
    projectsCta = "View Projects",
    liveHeading = "Live labs",
    liveCta = "Watch Live",
    check = "Check",
    newLetters = "New letters",
    start = "Start",
    back = "Back",
    menu = "Menu",
    navAbout = "About",
    navKmp = "KMP",
    navProjects = "Projects",
    navLive = "Live",
    github = "GitHub",
    labs = listOf(
        LabEntry(
            id = LabId.Unscramble,
            title = "Unscramble",
            level = "Beginner",
            brief = "A word puzzle lab built with shared Compose UI."
        ),
        LabEntry(
            id = LabId.Dice,
            title = "Dice",
            level = "Beginner",
            brief = "Roll two dice and see who wins."
        ),
        LabEntry(
            id = LabId.Hangman,
            title = "Hangman",
            level = "Beginner",
            brief = "Guess the hidden word one letter at a time."
        )
    )
)
