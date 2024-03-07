package tech.vodafone.githuprepoviewer.presentation.feature.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.R
import tech.vodafone.githuprepoviewer.domain.entities.DetailsRepoEntity
import tech.vodafone.githuprepoviewer.presentation.navigation.NavigationEvent
import tech.vodafone.githuprepoviewer.presentation.composable.AnimateScreenState
import tech.vodafone.githuprepoviewer.presentation.feature.details.components.RepoDetailsScreenContainer
import tech.vodafone.githuprepoviewer.presentation.feature.details.components.TopImageViewer
import tech.vodafone.githuprepoviewer.presentation.utils.NavigationController

@Composable
fun RepoDetailsScreen(
    navController: NavigationController,
    modifier: Modifier = Modifier,
    viewModel: RepoDetailsViewModel = hiltViewModel(),
    owner: String?,
    repo: String?
) {

    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.onEvent(DetailsRepoEvents.GetRepoDetails(repo = repo ?: "", owner = owner ?: ""))
    }

    val isRefreshing = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing.value),
        onRefresh = {
            coroutineScope.launch {
                isRefreshing.value = true
                viewModel.onEvent(
                    DetailsRepoEvents.GetRepoDetails(
                        repo = repo ?: "",
                        owner = owner ?: ""
                    )
                )
                delay(500)
                isRefreshing.value = false
            }
        },
    ) {
        screenState.AnimateScreenState(
            onClickRetry = {
                viewModel.onEvent(
                    DetailsRepoEvents.GetRepoDetails(
                        repo = repo ?: "",
                        owner = owner ?: ""
                    )
                )
            },
            onStable = {
                RepoDetailsScreenContainer(
                    modifier = modifier,
                    model = viewModel.dataState,
                ) {
                    navController.onEvent(
                        NavigationEvent.GoToRepositoryIssuesScreen(
                            repo = repo ?: "", owner = owner ?: ""
                        )
                    )
                }
            },
        )
    }


}


