package tech.vodafone.githuprepoviewer.presentation.navigation

import androidx.navigation.NavHostController
import tech.vodafone.githuprepoviewer.presentation.utils.NavigationController
import tech.vodafone.githuprepoviewer.presentation.utils.NavigationEventController
import tech.vodafone.githuprepoviewer.presentation.utils.parseArguments


class AppNavigationController(private val navController: NavHostController) :
    NavigationController {

    override fun onEvent(event: NavigationEventController) {
        when (event) {
            is NavigationEvent.GoToRepositoriesScreen -> navController.navigate(NavigationItems.Repos.path)
            is NavigationEvent.GoToRepositoryDetailsScreen -> navController.navigate(NavigationItems.Details.path.parseArguments(event.owner,event.repo))
            is NavigationEvent.GoToRepositoryIssuesScreen -> navController.navigate(NavigationItems.Issues.path.parseArguments(event.owner,event.repo))
        }
    }
}


