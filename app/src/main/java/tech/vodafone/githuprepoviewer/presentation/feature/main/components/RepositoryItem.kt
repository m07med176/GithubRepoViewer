package tech.vodafone.githuprepoviewer.presentation.feature.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jeziellago.compose.markdowntext.MarkdownText
import tech.vodafone.githuprepoviewer.domain.entities.ReposEntity
import tech.vodafone.githuprepoviewer.presentation.composable.AppTextView

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CategoryItemPreview() {
    val category = ReposEntity(
        name = "Hello Vodafone",
        owner = "Mohamed Arfa (:",
        description = "This is technical task of Vodafone recurring",
        starCount = null
    )
    RepositoryItem(category) {

    }
}

@Composable
fun RepositoryItem(model: ReposEntity, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier
        .padding(top = 24.dp)
        .padding(horizontal = 20.dp)
        .fillMaxWidth()
        .clickable { onClick() }
    ) {

        Text(
            text = model.name,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(800),
                color = MaterialTheme.colorScheme.primary,

                )
        )
        Spacer(modifier = Modifier.height(8.dp))

        model.owner?.let {
            Text(
                text = it,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                softWrap = true,
                modifier = Modifier.fillMaxWidth(0.7f)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        model.description?.let {
            MarkdownText(
                markdown = it,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                    color = MaterialTheme.colorScheme.onBackground,
                ))

        }

        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = MaterialTheme.colorScheme.onBackground)
        )
    }
}