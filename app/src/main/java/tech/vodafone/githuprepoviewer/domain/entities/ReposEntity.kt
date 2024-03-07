package tech.vodafone.githuprepoviewer.domain.entities

import tech.vodafone.githuprepoviewer.presentation.utils.UIModelBase


data class ReposEntity(
    val repos: List<ReposModel>? = null,
) : UIModelBase() {
    // repository's name, owner, description, and star count
    data class ReposModel(
        val name: String?,
        val description: String?,
        val owner: String?,
        val starCount: Int?
    )
}