package tech.vodafone.githuprepoviewer.presentation.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun changeStatusBarColor(color:Color=Color.White){
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    systemUiController.setStatusBarColor(
        color = color,
        darkIcons = true
    )
}



@Composable
fun SlideInOutAnimation(duration:Int =200,content: @Composable () -> Unit) {
    AnimatedVisibility(visibleState = remember {
        MutableTransitionState<Boolean>(
            initialState = false
        ) }.apply { targetState = true },
        modifier = Modifier,
        enter = slideInHorizontally(animationSpec = tween(duration)),
        exit = slideOutHorizontally(animationSpec = tween(duration))
    ) {
        content()
    }
}



