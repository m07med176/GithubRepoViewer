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

sealed interface ComponentState{
    data object Loading: ComponentState
    data object Stable: ComponentState
    data class Error(val errorMessage:String?=null): ComponentState
    data object Idle: ComponentState
}


@Composable
fun ComponentState.AnimateComponentState(
    modifier: Modifier = Modifier,
    transitionSpec: AnimatedContentTransitionScope<ComponentState>.() -> ContentTransform = {
        (fadeIn(animationSpec = tween(220, delayMillis = 90)) +
                scaleIn(initialScale = 0.92f, animationSpec = tween(220, delayMillis = 90)))
            .togetherWith(fadeOut(animationSpec = tween(90)))
    },
    contentAlignment: Alignment = Alignment.TopStart,
    onError: @Composable AnimatedContentScope.(message:String?) -> Unit = {},
    onLoading: @Composable AnimatedContentScope.() -> Unit = {},
    onStable: @Composable AnimatedContentScope.() -> Unit = {},
    onIdle: @Composable AnimatedContentScope.() -> Unit = {}
) {

    AnimatedContent(
        targetState = this,
        label = "animated state component",
        modifier = modifier,
        transitionSpec = transitionSpec,
        contentAlignment = contentAlignment,
        contentKey = ComponentState::hashCode
    ) {
        when (it) {
            is ComponentState.Error -> onError(it.errorMessage)
            is ComponentState.Loading -> onLoading()
            is ComponentState.Stable -> onStable()
            is ComponentState.Idle ->  onIdle()
        }
    }
}