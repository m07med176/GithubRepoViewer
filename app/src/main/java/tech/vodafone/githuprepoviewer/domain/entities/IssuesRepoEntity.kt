package tech.vodafone.githuprepoviewer.domain.entities

import tech.vodafone.githuprepoviewer.presentation.utils.UIModelBase

// UI Model
data class IssuesRepoEntity(
    val repoIssues: List<RepoIssues>? = null,
) : UIModelBase() {
    // title, author, date, and state (open/closed)
    data class RepoIssues(val title: String?, val author: String?, val state: String?)
}