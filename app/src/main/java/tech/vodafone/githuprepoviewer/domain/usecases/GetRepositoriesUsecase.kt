package tech.vodafone.githuprepoviewer.domain.usecases

import tech.vodafone.githuprepoviewer.domain.repositories.Repository
import javax.inject.Inject

class GetRepositoriesUsecase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke() = repository.getRepositories()
}