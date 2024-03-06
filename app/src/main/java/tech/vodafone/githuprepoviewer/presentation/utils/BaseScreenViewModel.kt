package tech.vodafone.githuprepoviewer.presentation.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


abstract class BaseScreenViewModel<S,T>(
    dataState: S,
    initialScreenState: ScreenState = ScreenState.Loading
) : ViewModel() {

    @Suppress("PropertyName")
    protected open val _dataState = MutableStateFlow(dataState)
    protected val uiStateValue get() = _dataState.value
    val uiState get() = _dataState.asStateFlow()

    private val _screenState by lazy { MutableStateFlow(initialScreenState) }
    val screenState get() = _screenState.asStateFlow()

    abstract fun onEvent(event:T)
     fun toLoadingScreenState() = _screenState.update { ScreenState.Loading }
     fun toStableScreenState() = _screenState.update { ScreenState.Stable }
     fun toErrorScreenState(message:String?) = _screenState.update { ScreenState.Error(message) }
     fun toNothingScreenState() = _screenState.update { ScreenState.Nothing }
}