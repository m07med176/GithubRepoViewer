package tech.vodafone.githuprepoviewer.presentation.feature.issues.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.vodafone.githuprepoviewer.R
import tech.vodafone.githuprepoviewer.presentation.composable.AnimateScreenState
import tech.vodafone.githuprepoviewer.presentation.composable.AppTextView
import tech.vodafone.githuprepoviewer.presentation.composable.ScreenState
import tech.vodafone.githuprepoviewer.presentation.feature.details.DetailsRepoEvents
import tech.vodafone.githuprepoviewer.presentation.feature.issues.RepoIssuesViewModel

@Composable
fun IssuesContent(
    viewModel: RepoIssuesViewModel?,
    screenState: ScreenState?,
    modifier: Modifier,
    onRetry:()->Unit,
) {
    Column {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(R.string.issues_page),
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight(800),
                color = MaterialTheme.colorScheme.primary,
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
                .background(color = MaterialTheme.colorScheme.onPrimary)
        )
        screenState?.AnimateScreenState(
            onClickRetry = onRetry,
            onStable = {
                LazyColumn(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    viewModel?.dataState?.let {
                        items(it) { data ->
                            IssueItem(data)
                        }
                    }
                }
            },
        )
    }
}