package tech.vodafone.githuprepoviewer.presentation.feature.main

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tech.vodafone.githuprepoviewer.R
import tech.vodafone.githuprepoviewer.presentation.navigation.NavigationEvent
import tech.vodafone.githuprepoviewer.presentation.utils.NavigationController

@Composable
fun SplashScreen(
    navController: NavigationController,
    viewModel: ReposViewModel = hiltViewModel()
) {
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true, block = {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 1500,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                })
        )
        delay(10L)
        navController.onEvent(NavigationEvent.GoToSplashScreen)
    })


    SplashAnimationWithContent()
}


@Composable
fun SplashAnimationWithContent() {
    val logo = painterResource(id = R.drawable.logo)
    val angle1Y = remember {
        Animatable(20f)
    }
    val angle2 = remember {
        Animatable(20f)
    }
    LaunchedEffect(angle1Y, angle2) {
        launch {
            angle1Y.animateTo(180f, animationSpec = tween(1500))
        }
        launch {
            angle2.animateTo(180f, animationSpec = tween(1500))
        }
    }

    Surface(Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
            onDraw = {
                withTransform({
                    // translate(angle1Y.value)
                    scale(scaleX = angle1Y.value, scaleY = angle2.value)

                }) {
                    drawCircle(color = Color.Red, radius = 8f)

                }
            }
        )
        Image(
            modifier = Modifier
                .width(40.dp)
                .padding(horizontal = 96.dp),
            contentScale = ContentScale.Fit,
            painter = logo,
            contentDescription = null
        )
    }

}

