package tech.vodafone.githuprepoviewer.domain.repositories

import kotlinx.coroutines.flow.Flow
import tech.vodafone.githuprepoviewer.data.source.local.paging.RepositoryPagingSource
import tech.vodafone.githuprepoviewer.data.source.local.paging.SearchRepositoryPagingSource
import tech.vodafone.githuprepoviewer.domain.entities.DetailsRepoEntity
import tech.vodafone.githuprepoviewer.domain.entities.IssuesRepoEntity
import tech.vodafone.githuprepoviewer.domain.entities.ReposEntity
import tech.vodafone.githuprepoviewer.domain.utils.ResourceState

interface Repository {

    fun getRepos(): RepositoryPagingSource
    fun searchRepos(search:String): SearchRepositoryPagingSource

    suspend fun getRepositories(): Flow<ResourceState<List<ReposEntity>>>

    suspend fun getRepositoryIssues(
        owner:String,
        repo:String,
    ): Flow<ResourceState<List<IssuesRepoEntity>>>

    suspend fun getRepositoryDetails(
        owner:String,
        repo:String,
    ): Flow<ResourceState<DetailsRepoEntity>>

    suspend fun insertCash(cash: List<ReposEntity>)

    fun getCashCount(): Int

}