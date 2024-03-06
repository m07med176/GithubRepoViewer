package tech.vodafone.githuprepoviewer.data.repository

import androidx.paging.PagingData
import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import tech.vodafone.githuprepoviewer.data.source.dto.BadeResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.data.utils.NetworkResponse

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