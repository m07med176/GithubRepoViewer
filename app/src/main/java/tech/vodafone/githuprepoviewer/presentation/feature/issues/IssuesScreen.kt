package tech.vodafone.githuprepoviewer.presentation.feature.issues

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.domain.entities.IssuesRepoEntity
import tech.vodafone.githuprepoviewer.presentation.composable.AnimateScreenState
import tech.vodafone.githuprepoviewer.presentation.feature.issues.components.IssuesContent
import tech.vodafone.githuprepoviewer.presentation.utils.NavigationController

@Composable
fun IssuesScreen(
    navController: NavigationController,
    modifier: Modifier = Modifier,
    viewModel: RepoIssuesViewModel = hiltViewModel(),
    owner: String?,
    repo: String?
) {

    val screenState by viewModel.screenState.collectAsStateWithLifecycle()
    val isRefreshing = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(true) {
        viewModel.onEvent(IssuesRepoEvents.GetRepoIssues(repo = repo ?: "", owner = owner ?: ""))
    }


    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing.value),
        onRefresh = {
            coroutineScope.launch {
                isRefreshing.value = true
                viewModel.onEvent(
                    IssuesRepoEvents.GetRepoIssues(
                        repo = repo ?: "",
                        owner = owner ?: ""
                    )
                )
                delay(500)
                isRefreshing.value = false
            }

        },
    ) {
        IssuesContent(
            screenState = screenState,
            viewModel = viewModel,
            modifier = modifier
        ){
            viewModel.onEvent(IssuesRepoEvents.GetRepoIssues(repo = repo ?: "", owner = owner ?: ""))
        }
    }


}


