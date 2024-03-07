package tech.vodafone.githuprepoviewer.domain.entities

// title, author, date, and state (open/closed)

data class IssuesRepoEntity(
    val title: String?, val author: String?, val state: String?
)