package tech.vodafone.githuprepoviewer.data.source.remote

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import tech.vodafone.githuprepoviewer.data.source.dto.BadeResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.data.source.remote.retrofit.CallApi
import tech.vodafone.githuprepoviewer.data.utils.NetworkResponse

class RemoteDataSourceImpl(
    private val api: CallApi
) : RemoteDataSource {
    override suspend fun getRepositories() = api.getRepositories()

    override suspend fun getRepositoryIssues(
        owner: String,
        repo: String
    ) = api.getRepositoryIssues(owner = owner, repo = repo)

    override suspend fun getRepositoryDetails(
        owner: String,
        repo: String
    ) = api.getRepositoryDetails(owner = owner, repo = repo)


}