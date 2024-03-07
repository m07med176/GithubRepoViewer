package tech.vodafone.githuprepoviewer.domain.usecases


import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import tech.vodafone.githuprepoviewer.data.source.local.paging.RepositoryPagingSource
import tech.vodafone.githuprepoviewer.data.source.local.paging.SearchRepositoryPagingSource
import tech.vodafone.githuprepoviewer.di.IoDispatcher
import tech.vodafone.githuprepoviewer.domain.repositories.Repository
import tech.vodafone.githuprepoviewer.domain.utils.ResourceState
import javax.inject.Inject

class SearchRepositoriesUsecase @Inject constructor(
    private val repository: Repository,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher) {

    operator fun invoke(search:String): Flow<ResourceState<SearchRepositoryPagingSource>> = flow {
        emit(ResourceState.Success(repository.searchRepos(search)))
    }.flowOn(ioDispatcher)

}