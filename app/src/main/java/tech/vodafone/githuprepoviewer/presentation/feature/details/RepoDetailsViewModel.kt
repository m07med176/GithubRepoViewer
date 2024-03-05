package tech.vodafone.githuprepoviewer.presentation.feature.details

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
class DetailsViewModel @Inject constructor(private val repository: Repository):
    BaseScreenViewModel<DetailsRepoUIData, DetailsRepoEvents>(
        initialScreenState = ScreenState.Loading(),
        dataState = DetailsRepoUIData()
    ) {

    override fun onEvent(event: DetailsRepoEvents){
        when(event){
            is DetailsRepoEvents.GetRepoDetails -> getDetailsOfRepository(event)
        }
    }

    private fun getDetailsOfRepository(event: DetailsRepoEvents.GetRepoDetails) {

        viewModelScope.launch {
            repository.getRepositoryDetails(owner = event.owner, repo = event.repo)
                .onEach(
                onLoading = { toLoadingScreenState() },
                onSuccess = { data ->
                    _uiState.update { state -> state.copy(repoDetails = data.toUIModel()) }
                    toStableScreenState()
                },
                onError = { toErrorScreenState(message = it) }
            ).launchIn(viewModelScope)

        }
    }
}

sealed interface DetailsRepoEvents{
    data class GetRepoDetails(val owner:String , val repo:String): DetailsRepoEvents
}