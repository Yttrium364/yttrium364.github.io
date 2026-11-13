package com.github.yttrium364.workflow_kmp_portfolio_site.domain

fun copyRu() = LocalizedCopy(
    role = "Мультиплатформенный разработчик",
    tagline = "Kotlin, общий интерфейс, Desktop и Web — то, на чём мне нравится создавать проекты.",
    aboutHeading = "Обо мне",
    about = "Я специализируюсь на создании эффективных интерфейсов с использованием современных кроссплатформенных технологий.",
    why = "Kotlin Multiplatform позволяет максимизировать переиспользование кода, сохраняя полный контроль над производительностью.",
    repo = "Посмотрите мои репозитории и ключевые библиотеки ниже.",
    kmpHeading = "Суперсилы KMP",
    projectsHeading = "Избранные Проекты",
    projectsCta = "Проекты",
    liveHeading = "Лайв-лаборатории",
    liveCta = "Смотреть Лайв",
    check = "Проверить",
    newLetters = "Новые буквы",
    start = "Старт",
    back = "Назад",
    menu = "Меню",
    navAbout = "Обо мне",
    navKmp = "KMP",
    navProjects = "Проекты",
    navLive = "Лаборатории",
    github = "GitHub",
    labs = listOf(
        LabEntry(
            id = LabId.Unscramble,
            title = "Unscramble",
            level = "Начальный",
            brief = "Лаборатория со словесной головоломкой на общем Compose UI."
        ),
        LabEntry(
            id = LabId.Dice,
            title = "Кости",
            level = "Начальный",
            brief = "Бросьте две кости и узнайте победителя."
        ),
        LabEntry(
            id = LabId.Hangman,
            title = "Виселица",
            level = "Начальный",
            brief = "Угадайте слово, выбирая буквы по одной."
        )
    )
)
