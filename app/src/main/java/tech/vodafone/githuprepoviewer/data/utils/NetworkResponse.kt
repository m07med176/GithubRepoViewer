package tech.vodafone.githuprepoviewer.data.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import tech.vodafone.githuprepoviewer.data.source.dto.BadeResponse
import java.io.IOException

fun <T : Any,K:Any> Flow<NetworkResponse<T, K>>.asResourceFlow() =
    this.onEach {
        when(it){
            is NetworkResponse.Loading -> NetworkResponse.Loading
            is NetworkResponse.Success ->  NetworkResponse.Success(it.body)
            is NetworkResponse.NetworkError -> NetworkResponse.NetworkError(it.error)
            is NetworkResponse.ApiError -> NetworkResponse.ApiError(it.body, it.code)
            is NetworkResponse.UnknownError -> NetworkResponse.UnknownError(Throwable(it.toString()))
        }
    }
        .onStart { emit(NetworkResponse.Loading) }
        .catch { emit(NetworkResponse.UnknownError(it)) }


sealed class NetworkResponse<out T : Any, out U : Any> {
    /**
     * Success response with body
     */
    data class Success<T : Any>(val body: T) : NetworkResponse<T, Nothing>()

    /**
     * Failure response with body
     */
    data class ApiError<U : Any>(val body: U, val code: Int) : NetworkResponse<Nothing, U>()

    /**
     * Network error
     */
    data class NetworkError(val error: IOException) : NetworkResponse<Nothing, Nothing>()

    /**
     * For example, json parsing error
     */
    data class UnknownError(val error: Throwable?) : NetworkResponse<Nothing, Nothing>()

    /**
     * For example, Loading progress bar
     */
    object Loading: NetworkResponse<Nothing, Nothing>()
}
