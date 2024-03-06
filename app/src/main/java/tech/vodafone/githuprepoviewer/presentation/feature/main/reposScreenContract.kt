package tech.vodafone.githuprepoviewer.presentation.feature.main

import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel
import tech.vodafone.githuprepoviewer.presentation.utils.UIModelBase


// UI Model
data class ReposUIData(
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

// Mapper
fun RepositoriesResponse.toUIModel() =
    map {
        ReposUIData.ReposModel(
            name = it.name,
            description = it.description,
            owner = it.owner?.login,
            starCount = it.id
        )
    }

fun RepositoriesResponseModel.toUIModel() =
    run {
        ReposUIData.ReposModel(
            name = name,
            description = description,
            owner = owner?.login,
            starCount = id
        )
    }


// Event
sealed interface ReposEvents {
    data class RequestSearch(val search:String):ReposEvents

    data object GetRepos : ReposEvents
}