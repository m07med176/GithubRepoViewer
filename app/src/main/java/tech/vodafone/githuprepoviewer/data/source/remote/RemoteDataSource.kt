package tech.vodafone.githuprepoviewer.data.source.remote

import tech.vodafone.githuprepoviewer.domain.entities.BadeResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.domain.utils.NetworkResponse

interface RemoteDataSource {
    suspend fun getRepositories(): NetworkResponse<RepositoriesResponse, BadeResponse>

    suspend fun getRepositoryIssues(
        owner: String,
        repo: String,
    ): NetworkResponse<RepositoryIssuesResponse, BadeResponse>

    suspend fun getRepositoryDetails(
        owner: String,
        repo: String,
    ): NetworkResponse<RepositoryDetailsResponse, BadeResponse>

}