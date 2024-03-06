package tech.vodafone.githuprepoviewer.presentation.feature.issues

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import tech.vodafone.githuprepoviewer.presentation.utils.AnimateScreenState
import tech.vodafone.githuprepoviewer.presentation.utils.NavigationController

@Composable
fun IssuesScreen(
    navController: NavigationController,
    modifier: Modifier = Modifier,
    viewModel: RepoIssuesViewModel = hiltViewModel(),
    owner:String?,
    repo:String?
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    LaunchedEffect(true){
        viewModel.onEvent(IssuesRepoEvents.GetRepoIssues(repo = repo?:"", owner = owner?:""))
    }

    screenState.AnimateScreenState(
        onStable = {
            LazyColumn(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
                uiState.repoIssues?.let {
                    items(it) { data ->
                        data.title?.let { title -> Text(text = title) }

                    }
                }
            }
        },
    )

}