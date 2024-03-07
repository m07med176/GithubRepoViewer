package tech.vodafone.githuprepoviewer.presentation.feature.issues

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.domain.entities.IssuesRepoEntity
import tech.vodafone.githuprepoviewer.domain.entities.ReposEntity
import tech.vodafone.githuprepoviewer.domain.usecases.GetRepositoryIssuesUsecase
import tech.vodafone.githuprepoviewer.presentation.utils.BaseViewModel
import tech.vodafone.githuprepoviewer.presentation.utils.onEach
import javax.inject.Inject

@HiltViewModel
class RepoIssuesViewModel @Inject constructor(private val getRepositoryIssuesUsecase: GetRepositoryIssuesUsecase):
    BaseViewModel<IssuesRepoEvents>() {

    var dataState:List<IssuesRepoEntity> by mutableStateOf(emptyList())
        private set

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
                    dataState = data
                    toStableScreenState()
                },
                onError = { toErrorScreenState(it) }
            ).launchIn(viewModelScope)

        }
    }
}

// Event
sealed interface IssuesRepoEvents{
    data class GetRepoIssues(val owner:String, val repo:String): IssuesRepoEvents
}