package tech.vodafone.githuprepoviewer.presentation.feature.details

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
import tech.vodafone.githuprepoviewer.domain.entities.DetailsRepoEntity
import tech.vodafone.githuprepoviewer.domain.usecases.GetRepositoryDetailsUsecase
import tech.vodafone.githuprepoviewer.presentation.utils.BaseViewModel
import tech.vodafone.githuprepoviewer.presentation.utils.onEach
import javax.inject.Inject

@HiltViewModel
class RepoDetailsViewModel @Inject constructor(private val getRepositoryDetailsUsecase: GetRepositoryDetailsUsecase):
    BaseViewModel<DetailsRepoEvents>() {

    var dataState:DetailsRepoEntity by mutableStateOf(DetailsRepoEntity())
        private set

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
                    dataState = data
                    toStableScreenState()
                },
                onError = { toErrorScreenState(it) }
            ).launchIn(viewModelScope)

        }
    }
}

// Event
sealed interface DetailsRepoEvents{
    data class GetRepoDetails(val owner:String , val repo:String): DetailsRepoEvents
}