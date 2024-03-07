package tech.vodafone.githuprepoviewer.presentation.composable

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import tech.vodafone.githuprepoviewer.R

enum class StateOfData(@RawRes val rowId:Int){
    Error(R.raw.network),
    NoData(R.raw.empty),
    Loading(R.raw.loading),
    Idle(R.raw.idle)
}

@Composable
fun LottieStateUI(modifier: Modifier,message:String?=null,type: StateOfData,onClickRetry:(()->Unit)?=null) {
    val isPlaying by remember {
        mutableStateOf(true)
    }

    val speed by remember {
        mutableFloatStateOf(1f)
    }

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(type.rowId)
    )


    val color = when(type){
        StateOfData.Error -> MaterialTheme.colorScheme.error
        StateOfData.NoData -> MaterialTheme.colorScheme.error
        StateOfData.Loading ->  MaterialTheme.colorScheme.secondary
        StateOfData.Idle ->  MaterialTheme.colorScheme.primary
    }
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isPlaying,
        speed = speed,
        restartOnPlay = false
    )

    Box(modifier = modifier, contentAlignment = Alignment.Center){
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            LottieAnimation(
                composition = composition,
                progress = progress,
                modifier = Modifier.size(250.dp)
            )
            message?.let {
                AppTextView(
                    value = it,
                    color = color,
                    modifier = Modifier.padding(horizontal = 10.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            onClickRetry?.let {
                OutlinedButton(onClick = onClickRetry) {
                    AppTextView(
                        value = stringResource(R.string.try_again),
                        color = color,
                        modifier = Modifier.padding(horizontal = 10.dp),
                        style = MaterialTheme.typography.headlineMedium.copy(fontSize = 17.sp)
                    )
                }
            }

        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LottieFilePreview() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        LottieStateUI(modifier = Modifier.size(150.dp), message = "Loading", type = StateOfData.Loading)
        Spacer(modifier = Modifier.height(10.dp))
        LottieStateUI(modifier = Modifier.size(150.dp), message = "No Data", type = StateOfData.NoData)
        Spacer(modifier = Modifier.height(10.dp))
        LottieStateUI(modifier = Modifier.size(150.dp), message = "No network", type = StateOfData.Error)
    }
}



@Composable
fun LoadingItem() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}