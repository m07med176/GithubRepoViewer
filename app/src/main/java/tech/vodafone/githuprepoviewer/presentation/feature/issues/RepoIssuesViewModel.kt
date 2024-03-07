package tech.vodafone.githuprepoviewer.presentation.feature.issues

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.data.source.toUIModel
import tech.vodafone.githuprepoviewer.domain.entities.IssuesRepoEntity
import tech.vodafone.githuprepoviewer.domain.usecases.GetRepositoryIssuesUsecase
import tech.vodafone.githuprepoviewer.domain.utils.onEach
import tech.vodafone.githuprepoviewer.presentation.utils.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class RepoIssuesViewModel @Inject constructor(private val getRepositoryIssuesUsecase: GetRepositoryIssuesUsecase):
    BaseViewModel<IssuesRepoEvents>() {

    private val _dataState = MutableStateFlow(IssuesRepoEntity())
    val uiStateValue get() = _dataState.value
    val uiState get() = _dataState.asStateFlow()
    override fun onEvent(event: IssuesRepoEvents){
        when(event){
            is IssuesRepoEvents.GetRepoIssues -> getIssuesOfRepository(event)
        }
    }

    private fun getIssuesOfRepository(event: IssuesRepoEvents.GetRepoIssues) {

        viewModelScope.launch {
            getRepositoryIssuesUsecase(owner = event.owner, repo = event.repo)
                .onEach(
                onLoading = { toLoadingScreenState() },
                onSuccess = { data ->
                    _dataState.update { state -> state.copy(repoIssues = data.toUIModel()) }
                    toStableScreenState()
                },
                onError = { toErrorScreenState(message = it) }
            ).launchIn(viewModelScope)

        }
    }
}

// Event
sealed interface IssuesRepoEvents{
    data class GetRepoIssues(val owner:String, val repo:String): IssuesRepoEvents
}