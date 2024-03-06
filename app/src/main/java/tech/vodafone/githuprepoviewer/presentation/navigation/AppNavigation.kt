package tech.vodafone.githuprepoviewer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tech.vodafone.githuprepoviewer.presentation.feature.details.RepoDetailsScreen
import tech.vodafone.githuprepoviewer.presentation.feature.issues.IssuesScreen
import tech.vodafone.githuprepoviewer.presentation.feature.main.ReposScreen

enum class NavigationItems(val path: String) {
    Repos("repos"),
    Details("details/{owner}/{repo}"),
    Issues("issues/{owner}/{repo}")
}

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String = NavigationItems.Repos.path,
) {

    val navController = AppNavigationController(navHostController)
    NavHost(navController = navHostController, startDestination = startDestination) {

        composable(NavigationItems.Repos.path) {
            ReposScreen(
                navController = navController,
                modifier = modifier
            )
        }

        composable(NavigationItems.Details.path) { backStackEntry ->
            val owner = backStackEntry.arguments?.getString("owner")
            val repo = backStackEntry.arguments?.getString("repo")
            RepoDetailsScreen(
                navController = navController,
                modifier = modifier,
                owner = owner,
                repo = repo
            )
        }

        composable(NavigationItems.Issues.path) { backStackEntry ->
            val owner = backStackEntry.arguments?.getString("owner")
            val repo = backStackEntry.arguments?.getString("repo")
            IssuesScreen(
                navController = navController,
                modifier = modifier,
                owner = owner,
                repo = repo
            )
        }

    }


}

