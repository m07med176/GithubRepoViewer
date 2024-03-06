package tech.vodafone.githuprepoviewer.presentation.feature.details

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
import tech.vodafone.githuprepoviewer.presentation.feature.issues.IssuesRepoEvents
import tech.vodafone.githuprepoviewer.presentation.feature.issues.RepoIssuesViewModel
import tech.vodafone.githuprepoviewer.presentation.navigation.NavigationItem
import tech.vodafone.githuprepoviewer.presentation.utils.AnimateScreenState

@Composable
fun RepoDetailsScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: RepoDetailsViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.onEvent(DetailsRepoEvents.GetRepoDetails(repo = "Hello-World", owner = "octocat"))
    }



    screenState.AnimateScreenState(
        onLoading = {
            Text(text = "Loading ..")
        },
        onError = {
            it?.let { Text(text = it) }
        },
        onNothing = {
            Text(text = "Nothing ..")
        },
        onStable = {
            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                uiState.repoDetails?.name?.let {
                    Text(text = it)
                }

                Button(onClick = {
                    navController.navigate(NavigationItem.Issues.route)
                }) {
                    Text(text = "Show Issues")
                }
            }
        },
    )


}