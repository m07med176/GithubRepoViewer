package tech.vodafone.githuprepoviewer.presentation.feature.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import tech.vodafone.githuprepoviewer.presentation.composable.ImageLoader

@Composable
fun TopImageViewer(image: String) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(270.dp)
        .shadow(5.dp),
        shape = RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp)

    ){
        Box(modifier = Modifier.fillMaxSize()){
            ImageLoader(url = image,modifier = Modifier.fillMaxSize()) {

            }
        }
    }

}