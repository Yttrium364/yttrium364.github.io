package com.github.yttrium364.workflow_kmp_portfolio_site.domain

data class LocalizedCopy(
    val role: String,
    val tagline: String,
    val about: String,
    val why: String,
    val repo: String,
    val aboutHeading: String,
    val kmpHeading: String,
    val projectsHeading: String,
    val projectsCta: String,
    val liveHeading: String,
    val liveCta: String,
    val check: String,
    val newLetters: String,
    val start: String,
    val github: String,
    val labs: List<LabEntry>,
)
