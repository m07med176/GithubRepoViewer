package tech.vodafone.githuprepoviewer.domain.utils

sealed class ResourceState<out T : Any> {
    data class Success<T : Any>(val data: T) : ResourceState<T>()
    data class Error(val error: Throwable) : ResourceState<Nothing>()
    data object Loading: ResourceState<Nothing>()
}