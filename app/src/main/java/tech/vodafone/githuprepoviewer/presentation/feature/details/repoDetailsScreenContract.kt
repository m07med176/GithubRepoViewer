package tech.vodafone.githuprepoviewer.presentation.feature.details

import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.presentation.utils.UIModelBase


data class DetailsRepoUIData(
    val repoDetails: RepoDetail? = null,
) : UIModelBase() {
    // and other relevant information
    data class RepoDetail(val name: String?, val owner: String?, val count: Int?)
}


fun RepositoryDetailsResponse.toUIModel() = run {
    DetailsRepoUIData.RepoDetail(
        name = name,
        owner = fullName,
        count = subscribersCount
    )
}