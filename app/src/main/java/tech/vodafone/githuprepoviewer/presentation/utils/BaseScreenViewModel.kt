package tech.vodafone.githuprepoviewer.presentation.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


abstract class BaseScreenViewModel<S,T>(
    dataState: S,
    initialScreenState: ScreenState = ScreenState.Stable()
) : ViewModel() {

    @Suppress("PropertyName")
    protected open val _uiState = MutableStateFlow(dataState)
    protected val uiStateValue get() = _uiState.value
    val uiState get() = _uiState.asStateFlow()

    // region Screen State
    private val _screenState by lazy { MutableStateFlow(initialScreenState) }
    val screenState get() = _screenState.asStateFlow()

    abstract fun onEvent(event:T)
     fun toLoadingScreenState(id:Int = 0) = _screenState.update { ScreenState.Loading(id) }
     fun toStableScreenState(id:Int = 0) = _screenState.update { ScreenState.Stable(id) }
     fun toErrorScreenState(id:Int = 0,message:String?) = _screenState.update { ScreenState.Error(id,message) }
     fun toInScreenLoading(id:Int = 0) = _screenState.update { ScreenState.InScreenLoading(id) }
     fun toIdleScreenState(id:Int = 0) = _screenState.update { ScreenState.Idle(id) }
    // endregion Screen State
}