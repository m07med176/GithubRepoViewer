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
import tech.vodafone.githuprepoviewer.domain.entities.IssuesRepoEntity
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

    Column {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "HeadLines",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight(800),
                color = Color(0xFF096FFA),
                letterSpacing = 2.4.sp,
            ),
            modifier = Modifier.padding(horizontal = 10.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color(0xFFEDEDED))
        )
        screenState.AnimateScreenState(
            onStable = {
                LazyColumn(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    uiState.repoIssues?.let {
                        items(it) { data ->
                            IssueItem(data)
                        }
                    }
                }
            },
        )
    }

}


@Preview(showBackground = true)
@Composable
fun IssueItemPreview() {
    val data = IssuesRepoEntity.RepoIssues(
        title = "CNN",
        author = "Mohamed",
        state  = "State"
    )

    IssueItem(data)

}


@Composable
fun IssueItem(model: IssuesRepoEntity.RepoIssues) {

    Column(modifier = Modifier
        .padding(horizontal = 20.dp)
        .padding(bottom = 16.dp)){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                model.title?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(800),
                            color = Color(0xFF096FFA),
                        )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                model.author?.let {
                    Text(
                        text = model.author,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 22.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        ),
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        softWrap = true
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                model.state?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6D787A),
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color(0xFFEDEDED))
        )
    }

}