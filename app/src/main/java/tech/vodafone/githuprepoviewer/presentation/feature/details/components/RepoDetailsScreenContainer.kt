package tech.vodafone.githuprepoviewer.presentation.feature.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jeziellago.compose.markdowntext.MarkdownText
import tech.vodafone.githuprepoviewer.R
import tech.vodafone.githuprepoviewer.domain.entities.DetailsRepoEntity
import tech.vodafone.githuprepoviewer.presentation.feature.details.RepoDetailsViewModel
import tech.vodafone.githuprepoviewer.presentation.utils.NavigationController

@Composable
fun RepoDetailsScreenContainer(
    model: DetailsRepoEntity,
    modifier: Modifier = Modifier,
    onClickIssues: () -> Unit
) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        model.avatar?.let {
            TopImageViewer(image = it)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.padding(horizontal = 21.dp)) {

            model.name?.let {
                Text(
                    text = it,
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 28.sp,
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row {

                model.owner?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                model.createdAt?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    )
                }

            }

            Spacer(modifier = Modifier.height(12.dp))


            model.description?.let {
                MarkdownText(
                    markdown = it,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(400),
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                )
            }


            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = onClickIssues,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).align(Alignment.CenterHorizontally)) {
                Text(
                    text = stringResource(R.string.show_issues),
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(400),
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                )
            }
        }


    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ArticleScreenPreview() {
    val data = DetailsRepoEntity(
        avatar = "https://s3-alpha-sig.figma.com/img/4be5/2149/8b032f03da97eeeb81aeddd35d65a2e2?Expires=1699228800&Signature=RRbNcEHE0xCMX9p7CPC9pRmhuuin0L-4Yh9vV0IMqzCpKkjfkHxDJErCgh6Yq4VoCz0OQF9lrh3rPoTrKsBw8ehnh4xVm~LD0GlLX9ZqiHHOog2A2ZwegzzPwzY4F9X2BggCwxWlyMWIfzPyir8grrMW-KlGVhhH1f2jxUpJpl1kcJw~nnnbM8bFVRAYoORXK7JN9KynGz5CQZxgpSUHXiMlegXtI-nMQTk6~W1pok68hZsWJkDCUjFSXKHwVRL~QPAmKWUglodo8Kqu3n9~ODpm48A2qguLzlmcEYLV3qjHfyQBbo5qUx-dQTBjqSrzNjKkWWfYfSLwSFisa72T6Q__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
        name = "Technical Task Repo",
        description = " this is dummy sting this is dummy sting this is dummy sting this is dummy sting this is dummy sting this is dummy sting ",
        createdAt = "Feb 26, 2023, 16.32 PM",
        owner = "Mohamed Arfa"
    )
    RepoDetailsScreenContainer(model = data) {}
}
