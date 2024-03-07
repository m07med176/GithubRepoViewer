package tech.vodafone.githuprepoviewer.domain.usecases

import tech.vodafone.githuprepoviewer.domain.repositories.Repository
import javax.inject.Inject

class GetRepositoryDetailsUsecase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(owner: String, repo: String) = repository.getRepositoryDetails(
        owner = owner,
        repo = repo
    )
}