package tech.vodafone.githuprepoviewer.data.source.remote

import tech.vodafone.githuprepoviewer.data.source.remote.retrofit.CallApi

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