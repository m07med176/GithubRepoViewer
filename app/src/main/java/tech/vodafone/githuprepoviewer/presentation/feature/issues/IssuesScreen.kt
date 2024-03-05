package tech.vodafone.githuprepoviewer.presentation.feature.issues

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import tech.vodafone.githuprepoviewer.presentation.feature.details.DetailsRepoEvents
import tech.vodafone.githuprepoviewer.presentation.navigation.NavigationItem

@Composable
fun IssuesScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: RepoIssuesViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    LaunchedEffect(true){
        viewModel.onEvent(IssuesRepoEvents.GetRepoIssues(repo = "Hello-World", owner = "octocat"))
    }

    LazyColumn(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        uiState.repoIssues?.let {
            items(it) { data ->
                data.title?.let { title -> Text(text = title) }

            }
        }
    }
}