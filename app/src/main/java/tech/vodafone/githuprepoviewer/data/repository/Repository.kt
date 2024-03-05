package tech.vodafone.githuprepoviewer.data.repository

import kotlinx.coroutines.flow.Flow
import tech.vodafone.githuprepoviewer.data.source.dto.BadeResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.data.utils.NetworkResponse

interface Repository {

    suspend fun getRepositories(): Flow<NetworkResponse<RepositoriesResponse, BadeResponse>>

    suspend fun getRepositoryIssues(
        owner:String,
        repo:String,
    ): Flow<NetworkResponse<RepositoryIssuesResponse, BadeResponse>>

    suspend fun getRepositoryDetails(
        owner:String,
        repo:String,
    ): Flow<NetworkResponse<RepositoryDetailsResponse, BadeResponse>>

}