package tech.vodafone.githuprepoviewer.presentation.feature.issues

import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.presentation.utils.UIModelBase


data class IssuesRepoUIData(
    val repoIssues: List<RepoIssues>? = null,
) : UIModelBase() {
    // title, author, date, and state (open/closed)
    data class RepoIssues(val title: String?, val author: String?, val state: String?)
}

fun RepositoryIssuesResponse.toUIModel() =
    map {
        IssuesRepoUIData.RepoIssues(
            title = it.title,
            author = it.authorAssociation,
            state = it.state
        )
    }
