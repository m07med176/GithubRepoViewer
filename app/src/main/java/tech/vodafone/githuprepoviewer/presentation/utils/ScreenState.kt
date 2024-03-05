package tech.vodafone.githuprepoviewer.presentation.utils

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

sealed interface ScreenState{
    data class InScreenLoading(val id:Int = 0): ScreenState
    data class Loading(val id:Int = 0): ScreenState
    data class Stable(val id:Int = 0): ScreenState
    data class Error(val id:Int = 0,val errorMessage:String?=null): ScreenState
    data class Idle(val id:Int = 0): ScreenState
}

//enum class ScreenState {
//    LOADING, STABLE, ERROR,IN_SCREEN_LOADING,IDLE
//}

val ScreenState.isError get() = this == ScreenState.Error()
val ScreenState.isLoading get() = this == ScreenState.Loading()

@Composable
fun ScreenState.inScreenLoading(content: @Composable () -> Unit) = content()

@Composable
fun ScreenState.AnimateScreenState(
    modifier: Modifier = Modifier,
    transitionSpec: AnimatedContentTransitionScope<ScreenState>.() -> ContentTransform = {
        (fadeIn(animationSpec = tween(220, delayMillis = 90)) +
                scaleIn(initialScale = 0.92f, animationSpec = tween(220, delayMillis = 90)))
            .togetherWith(fadeOut(animationSpec = tween(90)))
    },
    contentAlignment: Alignment = Alignment.TopStart,
    onError: @Composable AnimatedContentScope.(id:Int,message:String?) -> Unit = {id: Int, message: String? -> },
    onLoading: @Composable AnimatedContentScope.(id:Int) -> Unit = {},
    onStable: @Composable AnimatedContentScope.(id:Int) -> Unit = {},
    onIdle: @Composable AnimatedContentScope.(id:Int) -> Unit = {}
) {

    AnimatedContent(
        targetState = this,
        label = "animated state content",
        modifier = modifier,
        transitionSpec = transitionSpec,
        contentAlignment = contentAlignment,
        contentKey = ScreenState::hashCode
    ) {
        when (it) {
            is ScreenState.Error -> onError(it.id,it.errorMessage)
            is ScreenState.Idle ->  onIdle(it.id)
            is ScreenState.InScreenLoading -> {
                onLoading(it.id)
                onStable(it.id)
            }
            is ScreenState.Loading -> onLoading(it.id)
            is ScreenState.Stable -> onStable(it.id)
        }
    }
}