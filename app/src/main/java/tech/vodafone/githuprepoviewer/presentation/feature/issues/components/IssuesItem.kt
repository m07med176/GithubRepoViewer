package tech.vodafone.githuprepoviewer.presentation.feature.issues.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.vodafone.githuprepoviewer.R
import tech.vodafone.githuprepoviewer.domain.entities.IssuesRepoEntity
import tech.vodafone.githuprepoviewer.presentation.composable.AppTextView

@Composable
fun IssueItem(model: IssuesRepoEntity) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(bottom = 11.dp, top = 5.dp)
    ) {
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
                            color = MaterialTheme.colorScheme.primary,
                            )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                model.author?.let {
                    Text(
                        text = stringResource(R.string.author, it),
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 26.sp,
                            fontWeight = FontWeight(700),
                            color = MaterialTheme.colorScheme.onBackground
                        ),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        softWrap = true,
                        modifier = Modifier.fillMaxWidth(0.7f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                model.state?.let {
                    Text(
                        text = stringResource(R.string.state, it),
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onSurface
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
                .background(color = MaterialTheme.colorScheme.onBackground)
        )
    }

}


@Preview(showBackground = true)
@Composable
fun IssueItemPreview() {
    val data = IssuesRepoEntity(
        title = "Hello Vodafone :)",
        author = "Mohamed",
        state = "State"
    )

    IssueItem(data)

}
