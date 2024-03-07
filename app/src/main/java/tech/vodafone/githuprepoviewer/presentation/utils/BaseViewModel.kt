package tech.vodafone.githuprepoviewer.presentation.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import tech.vodafone.githuprepoviewer.domain.utils.ResourceState
import tech.vodafone.githuprepoviewer.presentation.composable.ScreenState

inline fun <D : Any> Flow<ResourceState<D>>.onEach(
    crossinline onSuccess: (D) -> Unit,
    crossinline onLoading: () -> Unit,
    crossinline onError: (Throwable) -> Unit
) = onEach {
    when (it) {
        is ResourceState.Loading -> onLoading()
        is ResourceState.Success -> onSuccess(it.data)
        is ResourceState.Error ->  onError(it.error)
    }
}

abstract class BaseViewModel<T>(
    initialScreenState: ScreenState = ScreenState.Loading
) : ViewModel() {

    private val _screenState by lazy { MutableStateFlow(initialScreenState) }
    val screenState get() = _screenState.asStateFlow()

    abstract fun onEvent(event:T)
     fun toLoadingScreenState() = _screenState.update { ScreenState.Loading }
     fun toStableScreenState() = _screenState.update { ScreenState.Stable }
     fun toErrorScreenState(exception:Throwable) = _screenState.update { ScreenState.Error(exception) }
     fun toNothingScreenState() = _screenState.update { ScreenState.Nothing }
}