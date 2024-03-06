package tech.vodafone.githuprepoviewer.presentation.feature.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.data.repository.Repository
import tech.vodafone.githuprepoviewer.data.utils.onEach
import tech.vodafone.githuprepoviewer.presentation.utils.BaseScreenViewModel
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor(private val repository: Repository):
    BaseScreenViewModel<ReposUIData, ReposEvents>(ReposUIData()) {

    private var _stateSearch: MutableSharedFlow<List<String>> = MutableSharedFlow()
    var stateSearch = _stateSearch.asSharedFlow()

    override fun onEvent(event: ReposEvents){
        when(event){
            is ReposEvents.GetRepos -> getRepositories()
            is ReposEvents.RequestSearch -> getRepositories()
        }
    }

    private fun getRepositories() {

        viewModelScope.launch {
            repository.getRepositories()
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

