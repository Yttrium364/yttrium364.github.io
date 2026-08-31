package com.github.yttrium364.workflow_kmp_portfolio_site.domain

enum class ProjectStatus {
    Active,
    Completed,
}

data class Project(
    val title: String,
    val short: String,
    val tags: Set<String>,
    val role: String,
    val status: ProjectStatus,
    val href: String,
)