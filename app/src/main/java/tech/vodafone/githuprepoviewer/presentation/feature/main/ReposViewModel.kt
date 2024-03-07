package tech.vodafone.githuprepoviewer.presentation.feature.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.data.source.toUIModel
import tech.vodafone.githuprepoviewer.domain.entities.ReposEntity
import tech.vodafone.githuprepoviewer.domain.usecases.GetRepositoriesUsecase
import tech.vodafone.githuprepoviewer.domain.utils.onEach
import tech.vodafone.githuprepoviewer.presentation.utils.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor(private val getRepositoriesUsecase: GetRepositoriesUsecase):
    BaseViewModel<ReposEvents>() {

   private val _dataState = MutableStateFlow(ReposEntity())
    val uiStateValue get() = _dataState.value
    val uiState get() = _dataState.asStateFlow()


    private var _stateSearch: MutableSharedFlow<List<String>> = MutableSharedFlow()
    var stateSearch = _stateSearch.asSharedFlow()


//    val pagingData = repository.getPagingCash()
//        .cachedIn(viewModelScope)
    override fun onEvent(event: ReposEvents){
        when(event){
            is ReposEvents.GetRepos -> getRepositories()
            is ReposEvents.RequestSearch -> getRepositories()
        }
    }

    private fun getRepositories() {

        viewModelScope.launch {
            getRepositoriesUsecase()
                .onEach(
                onLoading = { toLoadingScreenState() },
                onSuccess = { data ->
                    if (data.isNotEmpty()){
                        _dataState.update { state -> state.copy(repos = data.toUIModel()) }
                        toStableScreenState()
                    }else{
                        toNothingScreenState()
                    }

                },
                onError = { toErrorScreenState(message = it) }
            ).launchIn(viewModelScope)

        }
    }
}

// Event
sealed interface ReposEvents {
    data class RequestSearch(val search:String):ReposEvents

    data object GetRepos : ReposEvents
}