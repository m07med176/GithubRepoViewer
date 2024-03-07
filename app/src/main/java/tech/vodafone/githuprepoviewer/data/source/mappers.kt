package tech.vodafone.githuprepoviewer.data.source

import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.domain.entities.DetailsRepoEntity
import tech.vodafone.githuprepoviewer.domain.entities.IssuesRepoEntity
import tech.vodafone.githuprepoviewer.domain.entities.ReposEntity


// Mapper
fun RepositoryIssuesResponse.toUIModel() =
    map {
        IssuesRepoEntity.RepoIssues(
            title = it.title,
            author = it.authorAssociation,
            state = it.state
        )
    }


fun RepositoriesResponse.toUIModel() =
    map {
        ReposEntity.ReposModel(
            name = it.name,
            description = it.description,
            owner = it.owner?.login,
            starCount = it.id
        )
    }

fun RepositoriesResponseModel.toUIModel() =
    run {
        ReposEntity.ReposModel(
            name = name,
            description = description,
            owner = owner?.login,
            starCount = id
        )
    }


fun RepositoryDetailsResponse.toUIModel() = run {
    DetailsRepoEntity.RepoDetail(
        name = name,
        owner = fullName,
        count = subscribersCount
    )
}

