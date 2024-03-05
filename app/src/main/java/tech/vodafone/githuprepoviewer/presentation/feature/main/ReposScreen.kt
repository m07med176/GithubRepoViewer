package tech.vodafone.githuprepoviewer.presentation.feature.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import tech.vodafone.githuprepoviewer.presentation.feature.issues.IssuesRepoEvents
import tech.vodafone.githuprepoviewer.presentation.navigation.NavigationItem

@Composable
fun ReposScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ReposViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    LaunchedEffect(true){
        viewModel.onEvent(ReposEvents.GetRepos)
    }

    LazyColumn(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {

        item {
            Text(text = "Helloooo",modifier = Modifier.fillMaxWidth().height(10.dp).clickable {
                navController.navigate(NavigationItem.Details.route)
            })
        }
        uiState.repos?.let {
            items(it) { data ->
                data.name?.let { title -> Text(text = title,modifier = Modifier.fillMaxWidth().height(10.dp).clickable {
                    navController.navigate(NavigationItem.Details.route)
                }) }

            }
        }
    }
}