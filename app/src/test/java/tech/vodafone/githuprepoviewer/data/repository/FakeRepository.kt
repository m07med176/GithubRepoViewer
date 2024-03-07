package tech.vodafone.githuprepoviewer.data.repository

import kotlinx.coroutines.flow.Flow
import tech.vodafone.githuprepoviewer.data.source.NetworkResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.data.source.local.paging.SearchRepositoryPagingSource
import tech.vodafone.githuprepoviewer.domain.entities.BadeResponse
import tech.vodafone.githuprepoviewer.domain.entities.DetailsRepoEntity
import tech.vodafone.githuprepoviewer.domain.entities.IssuesRepoEntity
import tech.vodafone.githuprepoviewer.domain.entities.ReposEntity
import tech.vodafone.githuprepoviewer.domain.repositories.Repository
import tech.vodafone.githuprepoviewer.domain.utils.ResourceState

class FakeRepository(private val repository: Repository) {
    suspend fun getRepositories(): Flow<ResourceState<List<ReposEntity>>> = repository.getRepositories()

    suspend fun getRepositoryIssues(
        owner: String,
        repo: String,
    ): Flow<ResourceState<List<IssuesRepoEntity>>> = repository.getRepositoryIssues(owner,repo)

    suspend fun getRepositoryDetails(
        owner: String,
        repo: String,
    ): Flow<ResourceState<DetailsRepoEntity>> = repository.getRepositoryDetails(owner, repo)



    fun searchReposByName(searchQuery: String): SearchRepositoryPagingSource = repository.searchRepos(searchQuery)

    suspend fun insertCash(cash: List<ReposEntity>) {
        repository.insertCash(cash)
    }

    fun getCashCount(): Int = repository.getCashCount()
}