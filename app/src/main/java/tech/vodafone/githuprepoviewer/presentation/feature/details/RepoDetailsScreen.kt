package tech.vodafone.githuprepoviewer.presentation.feature.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import tech.vodafone.githuprepoviewer.presentation.navigation.NavigationEvent
import tech.vodafone.githuprepoviewer.presentation.utils.AnimateScreenState
import tech.vodafone.githuprepoviewer.presentation.utils.NavigationController

@Composable
fun RepoDetailsScreen(
    navController: NavigationController,
    modifier: Modifier = Modifier,
    viewModel: RepoDetailsViewModel = hiltViewModel(),
    owner:String?,
    repo:String?
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.onEvent(DetailsRepoEvents.GetRepoDetails(repo = repo?:"", owner = owner?:""))
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
                    navController.onEvent(NavigationEvent.GoToRepositoryIssuesScreen(repo = repo?:"", owner = owner?:""))

                }) {
                    Text(text = "Show Issues")
                }
            }
        },
    )


}