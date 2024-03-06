package tech.vodafone.githuprepoviewer.presentation.feature.issues

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.data.repository.Repository
import tech.vodafone.githuprepoviewer.data.utils.onEach
import tech.vodafone.githuprepoviewer.presentation.utils.BaseScreenViewModel
import javax.inject.Inject

@HiltViewModel
class RepoIssuesViewModel @Inject constructor(private val repository: Repository):
    BaseScreenViewModel<IssuesRepoUIData, IssuesRepoEvents>(IssuesRepoUIData()) {

    override fun onEvent(event: IssuesRepoEvents){
        when(event){
            is IssuesRepoEvents.GetRepoIssues -> getIssuesOfRepository(event)
        }
    }

    private fun getIssuesOfRepository(event: IssuesRepoEvents.GetRepoIssues) {

        viewModelScope.launch {
            repository.getRepositoryIssues(owner = event.owner, repo = event.repo)
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

sealed interface IssuesRepoEvents{
    data class GetRepoIssues(val owner:String, val repo:String): IssuesRepoEvents
}