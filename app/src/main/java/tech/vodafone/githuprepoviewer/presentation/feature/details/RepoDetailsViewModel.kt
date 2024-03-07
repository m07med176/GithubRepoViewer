package tech.vodafone.githuprepoviewer.presentation.feature.details

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.data.source.toUIModel
import tech.vodafone.githuprepoviewer.domain.entities.DetailsRepoEntity
import tech.vodafone.githuprepoviewer.domain.usecases.GetRepositoryDetailsUsecase
import tech.vodafone.githuprepoviewer.domain.utils.onEach
import tech.vodafone.githuprepoviewer.presentation.utils.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class RepoDetailsViewModel @Inject constructor(private val getRepositoryDetailsUsecase: GetRepositoryDetailsUsecase):
    BaseViewModel<DetailsRepoEvents>() {

    private val _dataState = MutableStateFlow(DetailsRepoEntity())
    val uiStateValue get() = _dataState.value
    val uiState get() = _dataState.asStateFlow()

    override fun onEvent(event: DetailsRepoEvents){
        when(event){
            is DetailsRepoEvents.GetRepoDetails -> getDetailsOfRepository(event)
        }
    }

    private fun getDetailsOfRepository(event: DetailsRepoEvents.GetRepoDetails) {

        viewModelScope.launch {
            getRepositoryDetailsUsecase(owner = event.owner, repo = event.repo)
                .onEach(
                onLoading = { toLoadingScreenState() },
                onSuccess = { data ->
                    _dataState.update { state -> state.copy(repoDetails = data.toUIModel()) }
                    toStableScreenState()
                },
                onError = { toErrorScreenState(message = it) }
            ).launchIn(viewModelScope)

        }
    }
}

// Event
sealed interface DetailsRepoEvents{
    data class GetRepoDetails(val owner:String , val repo:String): DetailsRepoEvents
}