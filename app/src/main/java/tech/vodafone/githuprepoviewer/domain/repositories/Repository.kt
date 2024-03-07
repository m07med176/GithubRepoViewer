package tech.vodafone.githuprepoviewer.domain.repositories

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import tech.vodafone.githuprepoviewer.domain.entities.BadeResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.domain.utils.NetworkResponse

interface Repository {

    fun getPagingCash(): Flow<PagingData<RepositoriesResponseModel>>

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