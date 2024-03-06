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

typealias AnimatedTypeScope = @Composable AnimatedContentScope.()->Unit
typealias AnimatedTypeScopeHaveString = @Composable AnimatedContentScope.(message:String?) -> Unit
sealed interface ScreenState{
    data object Loading: ScreenState
    data object Stable: ScreenState
    data object Nothing: ScreenState
    data class Error(val message:String?=null): ScreenState
}

val ScreenState.isError get() = this == ScreenState.Error()
val ScreenState.isLoading get() = this == ScreenState.Loading
val ScreenState.isEmpty get() = this == ScreenState.Nothing


@Composable
fun ScreenState.AnimateScreenState(
    modifier: Modifier = Modifier,
    transitionSpec: AnimatedContentTransitionScope<ScreenState>.() -> ContentTransform = {
        (fadeIn(animationSpec = tween(220, delayMillis = 90)) +
                scaleIn(initialScale = 0.92f, animationSpec = tween(220, delayMillis = 90)))
            .togetherWith(fadeOut(animationSpec = tween(90)))
    },
    contentAlignment: Alignment = Alignment.TopStart,
    onError: AnimatedTypeScopeHaveString?=null,
    onLoading: AnimatedTypeScope?=null,
    onStable: AnimatedTypeScope?=null,
    onNothing: AnimatedTypeScope?=null
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
            is ScreenState.Error -> if (onError != null) {
                onError(it.message)
            }
            is ScreenState.Loading -> if (onLoading != null) {
                onLoading()
            }
            is ScreenState.Stable -> if (onStable != null) {
                onStable()
            }
            is ScreenState.Nothing -> if (onNothing != null) {
                onNothing()
            }
        }
    }
}