package tech.vodafone.githuprepoviewer.presentation.feature.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.R
import tech.vodafone.githuprepoviewer.domain.entities.ReposEntity
import tech.vodafone.githuprepoviewer.presentation.composable.AnimateScreenState
import tech.vodafone.githuprepoviewer.presentation.composable.LoadingItem
import tech.vodafone.githuprepoviewer.presentation.composable.LottieStateUI
import tech.vodafone.githuprepoviewer.presentation.composable.ScreenState
import tech.vodafone.githuprepoviewer.presentation.composable.SearchField
import tech.vodafone.githuprepoviewer.presentation.composable.StateOfData
import tech.vodafone.githuprepoviewer.presentation.composable.handleExceptionToString
import tech.vodafone.githuprepoviewer.presentation.feature.main.ReposEvents
import tech.vodafone.githuprepoviewer.presentation.feature.main.ReposViewModel
import tech.vodafone.githuprepoviewer.presentation.navigation.NavigationEvent
import tech.vodafone.githuprepoviewer.presentation.utils.NavigationController


@Composable
fun RepoContent(
    navController: NavigationController?,
    screenState: ScreenState?,
    viewModel: ReposViewModel?,
    modifier: Modifier = Modifier,
    switchState: Boolean, onCheckedChange: (Boolean) -> Unit
) {

    var querySearch by remember { mutableStateOf("") }
    var toggleSave by remember { mutableStateOf(false) }

    Column {
        Box(
            modifier = Modifier
                .clickable {
                    toggleSave = !toggleSave
                    onCheckedChange(toggleSave)
                }
                .width(104.dp)
                .height(50.dp)
                .background(
                    color =  MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(bottomEnd = 12.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = if(switchState) stringResource(R.string.nightmode)else  stringResource(R.string.darkmode) ,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(800),
                    color = MaterialTheme.colorScheme.background,
                )
            )
        }
        Spacer(modifier = Modifier.height(32.dp))


            SearchField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                querySearch = it
                viewModel?.onEvent(ReposEvents.RequestSearch(querySearch))
            }


        if (querySearch.isNotBlank()) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(R.string.results_for, querySearch),
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,
                ),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }

        screenState?.AnimateScreenState(
            onStable = {
                ReposList(
                    pagingItems = viewModel?.dataState?.collectAsLazyPagingItems(),
                    navController = navController
                ) {
                    viewModel?.onEvent(ReposEvents.GetRepos)
                }
            },
            onClickRetry = {
                viewModel?.onEvent(ReposEvents.GetRepos)
            }
        )
    }
}


@Composable
fun ReposList(
    pagingItems: LazyPagingItems<ReposEntity>?,
    navController: NavigationController?,
    modifier: Modifier = Modifier,
    onRetryClick: () -> Unit
) {
    LazyColumn(modifier = modifier) {
        pagingItems?.apply {
            if (pagingItems.itemCount == 0) {
                item {
                    LottieStateUI(
                        modifier = Modifier.fillParentMaxSize(),
                        type = StateOfData.NoData
                    )
                }
            } else {
                items(pagingItems.itemCount) { index ->
                    pagingItems[index]?.let { data ->
                        RepositoryItem(data) {
                            navController?.onEvent(
                                NavigationEvent.GoToRepositoryDetailsScreen(
                                    repo = data.name,
                                    owner = data.owner ?: ""
                                )
                            )
                        }
                    }
                }
            }

            when {
                loadState.refresh is LoadState.Loading -> {
                    item {
                        LottieStateUI(
                            modifier = Modifier.fillParentMaxSize(),
                            type = StateOfData.Loading
                        )
                    }
                }

                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }

                loadState.refresh is LoadState.Error -> {
                    val e = pagingItems.loadState.refresh as LoadState.Error
                    item {
                        LottieStateUI(
                            modifier = Modifier.fillParentMaxSize(),
                            message = handleExceptionToString(exception = e.error),
                            type = StateOfData.Error,
                            onClickRetry = onRetryClick
                        )
                    }
                }

                loadState.append is LoadState.Error -> {
                    val e = pagingItems.loadState.append as LoadState.Error
                    item {
                        LottieStateUI(
                            modifier = Modifier.fillParentMaxSize(),
                            message = handleExceptionToString(exception = e.error),
                            type = StateOfData.Error,
                            onClickRetry = onRetryClick
                        )
                    }

                }
            }
        }
    }
}



