package tech.vodafone.githuprepoviewer.presentation.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import tech.vodafone.githuprepoviewer.R

typealias AnimatedTypeScope = @Composable AnimatedContentScope.() -> Unit
typealias AnimatedTypeScopeOfError = @Composable AnimatedContentScope.(exception: Throwable) -> Unit

sealed interface ScreenState {
    data object Loading : ScreenState
    data object Stable : ScreenState
    data object Nothing : ScreenState
    data class Error(val exception: Throwable) : ScreenState
}

@Composable
fun ScreenState.AnimateScreenState(
    modifier: Modifier = Modifier,
    transitionSpec: AnimatedContentTransitionScope<ScreenState>.() -> ContentTransform = {
        (fadeIn(animationSpec = tween(220, delayMillis = 90)) +
                scaleIn(initialScale = 0.92f, animationSpec = tween(220, delayMillis = 90)))
            .togetherWith(fadeOut(animationSpec = tween(90)))
    },
    contentAlignment: Alignment = Alignment.TopStart,
    onClickRetry:(()->Unit)?=null,
    onError: AnimatedTypeScopeOfError? = null,
    onLoading: AnimatedTypeScope? = null,
    onStable: AnimatedTypeScope,
    onNothing: AnimatedTypeScope? = null
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
                onError(it.exception)
            } else {
                LottieStateUI(
                    modifier = modifier,
                    message = handleExceptionToString(exception = it.exception),
                    type = StateOfData.Error,
                    onClickRetry = onClickRetry
                )
            }

            is ScreenState.Loading -> if (onLoading != null) {
                onLoading()
            } else {
                LottieStateUI(
                    modifier = modifier,
                    message = stringResource(R.string.loading),
                    type = StateOfData.Loading
                )
            }

            is ScreenState.Stable -> onStable()
            is ScreenState.Nothing -> if (onNothing != null) {
                onNothing()
            } else {
                LottieStateUI(
                    modifier = modifier,
                    message = stringResource(R.string.no_data),
                    type = StateOfData.NoData,
                    onClickRetry = onClickRetry
                )
            }
        }
    }
}