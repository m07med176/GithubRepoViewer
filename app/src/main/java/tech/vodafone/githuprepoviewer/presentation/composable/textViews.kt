package tech.vodafone.githuprepoviewer.presentation.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun AppTextView(modifier:Modifier = Modifier,value:String,color:Color,style:TextStyle) {
    Text(
        text = value,
        style = style,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        softWrap = true,
        color = color,
        modifier = modifier,
    )
}