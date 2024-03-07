package tech.vodafone.githuprepoviewer.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import tech.vodafone.githuprepoviewer.data.source.local.LocalDataSource
import tech.vodafone.githuprepoviewer.data.source.remote.RemoteDataSource
import tech.vodafone.githuprepoviewer.data.source.asResourceFlow
import tech.vodafone.githuprepoviewer.data.source.dto.toDTO
import tech.vodafone.githuprepoviewer.data.source.local.paging.RepositoryPagingSource
import tech.vodafone.githuprepoviewer.data.source.local.paging.SearchRepositoryPagingSource
import tech.vodafone.githuprepoviewer.di.IoDispatcher
import tech.vodafone.githuprepoviewer.domain.entities.DetailsRepoEntity
import tech.vodafone.githuprepoviewer.domain.entities.IssuesRepoEntity
import tech.vodafone.githuprepoviewer.domain.entities.ReposEntity
import tech.vodafone.githuprepoviewer.domain.repositories.Repository
import tech.vodafone.githuprepoviewer.domain.utils.ResourceState
import javax.inject.Inject

class RepositoryImpl  @Inject constructor(
    private val localDataSource:LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) : Repository {
    override fun getRepos(): RepositoryPagingSource
     = RepositoryPagingSource(localDataSource,ioDispatcher)

    override fun searchRepos(search: String): SearchRepositoryPagingSource  = SearchRepositoryPagingSource(localDataSource,ioDispatcher,search)

    override suspend fun getRepositories(): Flow<ResourceState<List<ReposEntity>>> =
        flowOf(remoteDataSource.getRepositories()).flowOn(ioDispatcher).asResourceFlow()

    override suspend fun getRepositoryIssues(
        owner: String,
        repo: String
    ): Flow<ResourceState<List<IssuesRepoEntity>>> =
        flowOf(remoteDataSource.getRepositoryIssues(owner = owner, repo = repo))
            .flowOn(ioDispatcher)
            .asResourceFlow()

    override suspend fun getRepositoryDetails(
        owner: String,
        repo: String
    ): Flow<ResourceState<DetailsRepoEntity>> =
        flowOf(remoteDataSource.getRepositoryDetails(owner = owner, repo = repo))
            .flowOn(ioDispatcher)
            .asResourceFlow()

    override suspend fun insertCash(cash: List<ReposEntity>) {
        val items = cash.map { it.toDTO() }
        localDataSource.insertCash(items)
    }

    override fun getCashCount() = localDataSource.getCashCount()

}