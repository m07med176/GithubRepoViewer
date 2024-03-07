package tech.vodafone.githuprepoviewer.data.source.remote

import org.junit.Assert.*
import tech.vodafone.githuprepoviewer.data.source.NetworkResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.domain.entities.BadeResponse

class FakeRemoteDataSource(private val remoteDataSource: RemoteDataSource){
    suspend fun getRepositories(): NetworkResponse<RepositoriesResponse, BadeResponse> = remoteDataSource.getRepositories()

    suspend fun getRepositoryIssues(
        owner: String,
        repo: String,
    ): NetworkResponse<RepositoryIssuesResponse, BadeResponse> = remoteDataSource.getRepositoryIssues(owner,repo)

    suspend fun getRepositoryDetails(
        owner: String,
        repo: String,
    ): NetworkResponse<RepositoryDetailsResponse, BadeResponse> = remoteDataSource.getRepositoryDetails(owner, repo)


}