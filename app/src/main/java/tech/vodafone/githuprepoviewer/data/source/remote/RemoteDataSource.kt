package tech.vodafone.githuprepoviewer.data.source.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import tech.vodafone.githuprepoviewer.data.source.dto.BadeResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.data.source.remote.retrofit.EndPoints
import tech.vodafone.githuprepoviewer.data.utils.NetworkResponse

interface RemoteDataSource {
    fun getRepositories(): NetworkResponse<RepositoriesResponse, BadeResponse>

    fun getRepositoryIssues(
        owner: String,
        repo: String,
    ): NetworkResponse<RepositoryIssuesResponse, BadeResponse>

    fun getRepositoryDetails(
        owner: String,
        repo: String,
    ): NetworkResponse<RepositoryDetailsResponse, BadeResponse>

}