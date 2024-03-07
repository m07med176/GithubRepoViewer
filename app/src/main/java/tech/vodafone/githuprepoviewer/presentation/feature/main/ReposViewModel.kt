package tech.vodafone.githuprepoviewer.presentation.feature.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.domain.entities.ReposEntity
import tech.vodafone.githuprepoviewer.domain.usecases.GetRepositoriesUsecase
import tech.vodafone.githuprepoviewer.domain.usecases.SearchRepositoriesUsecase
import tech.vodafone.githuprepoviewer.presentation.utils.BaseViewModel
import tech.vodafone.githuprepoviewer.presentation.utils.onEach
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor(
    private val getRepositoriesUsecase: GetRepositoriesUsecase,
    private val searchRepositoriesUsecase: SearchRepositoriesUsecase
) :
    BaseViewModel<ReposEvents>() {


    var dataState: Flow<PagingData<ReposEntity>>? by mutableStateOf(null)
        private set

    var isDarkThemeEnabled = mutableStateOf(false)
        private set

    override fun onEvent(event: ReposEvents) {
        when (event) {
            is ReposEvents.GetRepos -> getRepositories()
            is ReposEvents.RequestSearch -> searchRequest(event.search)
            is ReposEvents.ChangeTheme -> setTheme(event.isDarkTheme)
        }
    }


    val DELAY: Long = 1000
    var searchJob: Job? = null
    private fun searchRequest(search: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(DELAY)
            searchRepositoriesUsecase(search)
                .onEach(
                    onLoading = { toLoadingScreenState() },
                    onSuccess = { data ->
                        dataState = Pager(
                            PagingConfig(
                                pageSize = 5,
                                initialLoadSize = 5
                            )
                        ) { data }.flow.cachedIn(viewModelScope)
                        toStableScreenState()
                    },
                    onError = { toErrorScreenState(it) }
                ).launchIn(viewModelScope)
        }
    }

    private fun getRepositories() {
        viewModelScope.launch {
            getRepositoriesUsecase()
                .onEach(
                    onLoading = { toLoadingScreenState() },
                    onSuccess = { data ->
                        dataState = Pager(
                            PagingConfig(
                                pageSize = 5,
                                initialLoadSize = 5
                            )
                        ) { data }.flow.cachedIn(viewModelScope)
                        toStableScreenState()
                    },
                    onError = { toErrorScreenState(it) }
                ).launchIn(viewModelScope)
        }
    }

    private fun setTheme(isDarkTheme: Boolean) {
        isDarkThemeEnabled.value = isDarkTheme
    }
}

// Event
sealed interface ReposEvents {
    data class RequestSearch(val search: String) : ReposEvents

    data object GetRepos : ReposEvents
    data class ChangeTheme(val isDarkTheme: Boolean) : ReposEvents
}