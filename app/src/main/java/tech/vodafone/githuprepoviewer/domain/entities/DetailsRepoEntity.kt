package tech.vodafone.githuprepoviewer.domain.entities

import tech.vodafone.githuprepoviewer.presentation.utils.UIModelBase

data class DetailsRepoEntity(
    val repoDetails: RepoDetail? = null,
) : UIModelBase() {
    // and other relevant information
    data class RepoDetail(val name: String?, val owner: String?, val count: Int?)
}