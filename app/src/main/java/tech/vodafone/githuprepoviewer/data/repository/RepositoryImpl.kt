package tech.vodafone.githuprepoviewer.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import tech.vodafone.githuprepoviewer.data.source.dto.BadeResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.data.source.remote.retrofit.CallApi
import tech.vodafone.githuprepoviewer.data.utils.NetworkResponse
import tech.vodafone.githuprepoviewer.data.utils.asResourceFlow
import javax.inject.Inject

class RepositoryImpl  @Inject constructor(
    private val api: CallApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : Repository {
    override suspend fun getRepositories(): Flow<NetworkResponse<RepositoriesResponse, BadeResponse>> =
        flowOf(api.getRepositories())
            .flowOn(ioDispatcher)
            .asResourceFlow()

    override suspend fun getRepositoryIssues(
        owner: String,
        repo: String
    ): Flow<NetworkResponse<RepositoryIssuesResponse, BadeResponse>> =
        flowOf(api.getRepositoryIssues(owner = owner, repo = repo))
            .flowOn(ioDispatcher)
            .asResourceFlow()

    override suspend fun getRepositoryDetails(
        owner: String,
        repo: String
    ): Flow<NetworkResponse<RepositoryDetailsResponse, BadeResponse>> =
        flowOf(api.getRepositoryDetails(owner = owner, repo = repo))
            .flowOn(ioDispatcher)
            .asResourceFlow()
}