package tech.vodafone.githuprepoviewer.data.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import tech.vodafone.githuprepoviewer.domain.entities.BadeResponse
import tech.vodafone.githuprepoviewer.domain.utils.DomainMapping
import tech.vodafone.githuprepoviewer.domain.utils.NetworkException
import tech.vodafone.githuprepoviewer.domain.utils.ResourceState
import java.io.IOException

fun <D : Any,T : DomainMapping<D>> Flow<NetworkResponse<T, BadeResponse>>.asResourceFlow() =
    this.map {
        when(it){
            is NetworkResponse.Loading -> ResourceState.Loading
            is NetworkResponse.Success -> ResourceState.Success(it.body.toDomainModel())
            is NetworkResponse.NetworkError -> ResourceState.Error(it.error)
            is NetworkResponse.ApiError -> ResourceState.Error(
                NetworkException(
                    it.body.message,
                    it.code
                )
            )
            is NetworkResponse.UnknownError -> ResourceState.Error(it.error ?: Exception())
        }
    }
        .onStart { emit(ResourceState.Loading) }
        .catch { emit(ResourceState.Error(it)) }


sealed class NetworkResponse<out T : Any, out U : Any> {
    data class Success<T : Any>(val body: T) : NetworkResponse<T, Nothing>()
    data class ApiError<U : Any>(val body: U, val code: Int) : NetworkResponse<Nothing, U>()
    data class NetworkError(val error: IOException) : NetworkResponse<Nothing, Nothing>()
    data class UnknownError(val error: Throwable?) : NetworkResponse<Nothing, Nothing>()
    data object Loading: NetworkResponse<Nothing, Nothing>()
}


