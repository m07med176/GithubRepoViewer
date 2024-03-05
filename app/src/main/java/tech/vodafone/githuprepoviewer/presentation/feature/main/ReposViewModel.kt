package tech.vodafone.githuprepoviewer.presentation.feature.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.data.repository.Repository
import tech.vodafone.githuprepoviewer.data.utils.onEach
import tech.vodafone.githuprepoviewer.presentation.utils.BaseScreenViewModel
import tech.vodafone.githuprepoviewer.presentation.utils.ScreenState
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor(private val repository: Repository):
    BaseScreenViewModel<ReposUIData, ReposEvents>(
        initialScreenState = ScreenState.Loading(),
        dataState = ReposUIData()
    ) {

    override fun onEvent(event: ReposEvents){
        when(event){
            is ReposEvents.GetRepos -> getRepositories()
        }
    }

    private fun getRepositories() {

        viewModelScope.launch {
            repository.getRepositories()
                .onEach(
                onLoading = { toLoadingScreenState() },
                onSuccess = { data ->
                    _uiState.update { state -> state.copy(repos = data.toUIModel()) }
                    toStableScreenState()
                },
                onError = { toErrorScreenState(message = it) }
            ).launchIn(viewModelScope)

        }
    }
}

sealed interface ReposEvents{
    data object GetRepos: ReposEvents
}