package tech.vodafone.githuprepoviewer.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import tech.vodafone.githuprepoviewer.data.source.dto.BadeResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.data.source.local.LocalDataSource
import tech.vodafone.githuprepoviewer.data.source.remote.RemoteDataSource
import tech.vodafone.githuprepoviewer.data.utils.NetworkResponse
import tech.vodafone.githuprepoviewer.data.utils.asResourceFlow
import tech.vodafone.githuprepoviewer.di.IoDispatcher
import javax.inject.Inject

class RepositoryImpl  @Inject constructor(
    private val localDataSource:LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) : Repository {
    override suspend fun getRepositories(): Flow<NetworkResponse<RepositoriesResponse, BadeResponse>> = flow {
        val response = remoteDataSource.getRepositories()
       when(response){
           is NetworkResponse.Success -> {
               if (localDataSource.getCashCount()  == 0){
                   response.body.forEach{ item->
                       localDataSource.insertCash(item)
                   }
               }
           }
           else -> {}
       }
        emit(response)
    }.flowOn(ioDispatcher).asResourceFlow()

    override suspend fun getRepositoryIssues(
        owner: String,
        repo: String
    ): Flow<NetworkResponse<RepositoryIssuesResponse, BadeResponse>> =
        flowOf(remoteDataSource.getRepositoryIssues(owner = owner, repo = repo))
            .flowOn(ioDispatcher)
            .asResourceFlow()

    override suspend fun getRepositoryDetails(
        owner: String,
        repo: String
    ): Flow<NetworkResponse<RepositoryDetailsResponse, BadeResponse>> =
        flowOf(remoteDataSource.getRepositoryDetails(owner = owner, repo = repo))
            .flowOn(ioDispatcher)
            .asResourceFlow()
}