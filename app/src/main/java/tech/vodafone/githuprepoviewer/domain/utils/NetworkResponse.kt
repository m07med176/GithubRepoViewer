package tech.vodafone.githuprepoviewer.domain.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import tech.vodafone.githuprepoviewer.domain.entities.BadeResponse
import java.io.IOException

fun <T : Any,K:Any> Flow<NetworkResponse<T, K>>.asResourceFlow() =
    this.onEach {
        when(it){
            is NetworkResponse.Loading -> NetworkResponse.Loading
            is NetworkResponse.Success -> NetworkResponse.Success(it.body)
            is NetworkResponse.NetworkError -> NetworkResponse.NetworkError(it.error)
            is NetworkResponse.ApiError -> NetworkResponse.ApiError(it.body, it.code)
            is NetworkResponse.UnknownError -> NetworkResponse.UnknownError(Throwable(it.toString()))
        }
    }
        .onStart { emit(NetworkResponse.Loading) }
        .catch { emit(NetworkResponse.UnknownError(it)) }


sealed class NetworkResponse<out T : Any, out U : Any> {
    data class Success<T : Any>(val body: T) : NetworkResponse<T, Nothing>()
    data class ApiError<U : Any>(val body: U, val code: Int) : NetworkResponse<Nothing, U>()
    data class NetworkError(val error: IOException) : NetworkResponse<Nothing, Nothing>()
    data class UnknownError(val error: Throwable?) : NetworkResponse<Nothing, Nothing>()
    object Loading: NetworkResponse<Nothing, Nothing>()
}


inline fun <D : Any> Flow<NetworkResponse<D, BadeResponse>>.onEach(
    crossinline onSuccess: (D) -> Unit,
    crossinline onLoading: () -> Unit,
    crossinline onError: (String?) -> Unit
) = onEach {
    when (it) {
        is NetworkResponse.Loading -> onLoading()
        is NetworkResponse.Success -> onSuccess(it.body)
        is NetworkResponse.ApiError ->  onError(it.body.message)
        is NetworkResponse.NetworkError -> onError(it.error.message)
        is NetworkResponse.UnknownError -> onError(it.error?.message)
    }
}