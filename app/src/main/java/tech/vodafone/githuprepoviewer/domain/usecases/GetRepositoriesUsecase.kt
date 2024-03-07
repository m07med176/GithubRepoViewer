package tech.vodafone.githuprepoviewer.domain.usecases


import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import tech.vodafone.githuprepoviewer.data.source.local.paging.RepositoryPagingSource
import tech.vodafone.githuprepoviewer.di.IoDispatcher
import tech.vodafone.githuprepoviewer.domain.repositories.Repository
import tech.vodafone.githuprepoviewer.domain.utils.ResourceState
import javax.inject.Inject

class GetRepositoriesUsecase @Inject constructor(
    private val repository: Repository,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) {

     operator fun invoke(): Flow<ResourceState<RepositoryPagingSource>> = flow {
         if (repository.getCashCount() == 0){
             repository.getRepositories().collect {
                 when (it) {
                     is ResourceState.Success -> {
                         repository.insertCash(it.data)
                         emit(ResourceState.Success(repository.getRepos()))
                     }

                     is ResourceState.Error -> emit(ResourceState.Error(Exception()))
                     is ResourceState.Loading -> emit(ResourceState.Loading)
                 }
             }
         } else{
             emit(ResourceState.Success(repository.getRepos()))
         }
    }.flowOn(ioDispatcher)

}