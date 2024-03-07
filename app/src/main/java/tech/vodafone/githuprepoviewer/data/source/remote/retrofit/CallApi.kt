package tech.vodafone.githuprepoviewer.data.source.remote.retrofit

import retrofit2.http.GET
import retrofit2.http.Path
import tech.vodafone.githuprepoviewer.domain.entities.BadeResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.NetworkResponse


/**
 * # Network API
 */
@JvmSuppressWildcards
interface CallApi {

    @GET(EndPoints.REPOSITORIES)
    suspend fun getRepositories(): NetworkResponse<RepositoriesResponse, BadeResponse>

    @GET(EndPoints.REPOSITORY_ISSUES)
    suspend fun getRepositoryIssues(
        @Path("owner") owner:String,
        @Path("repo") repo:String,
    ): NetworkResponse<RepositoryIssuesResponse, BadeResponse>

    @GET(EndPoints.REPOSITORY_DETAILS)
    suspend fun getRepositoryDetails(
        @Path("owner") owner:String,
        @Path("repo") repo:String,
    ): NetworkResponse<RepositoryDetailsResponse, BadeResponse>
}