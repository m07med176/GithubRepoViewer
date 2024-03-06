package tech.vodafone.githuprepoviewer.presentation.navigation

import tech.vodafone.githuprepoviewer.presentation.utils.NavigationEventController

sealed class NavigationEvent: NavigationEventController() {
    data object GoToSplashScreen : NavigationEvent()
    data object GoToRepositoriesScreen : NavigationEvent()
    data class GoToRepositoryDetailsScreen(val owner: String, val repo: String) : NavigationEvent()
    data class GoToRepositoryIssuesScreen(val owner: String, val repo: String) : NavigationEvent()
}