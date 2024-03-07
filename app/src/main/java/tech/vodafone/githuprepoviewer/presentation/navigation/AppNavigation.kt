package tech.vodafone.githuprepoviewer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tech.vodafone.githuprepoviewer.presentation.composable.SlideInOutAnimation
import tech.vodafone.githuprepoviewer.presentation.feature.details.RepoDetailsScreen
import tech.vodafone.githuprepoviewer.presentation.feature.issues.IssuesScreen
import tech.vodafone.githuprepoviewer.presentation.feature.main.ReposScreen
import tech.vodafone.githuprepoviewer.presentation.feature.main.SplashScreen
import tech.vodafone.githuprepoviewer.system.DataStoreUtil

enum class NavigationItems(val path: String) {
    Splash("splash"),
    Repos("repos"),
    Details("details/{owner}/{repo}"),
    Issues("issues/{owner}/{repo}")
}

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    dataStoreUtil: DataStoreUtil,
    navHostController: NavHostController,
    startDestination: String = NavigationItems.Splash.path,
) {

    val navController = AppNavigationController(navHostController)
    NavHost(navController = navHostController, startDestination = startDestination) {

        composable(NavigationItems.Splash.path) {
            SlideInOutAnimation {
                SplashScreen(
                    navController = navController
                )
            }
        }

        composable(NavigationItems.Repos.path) {
            SlideInOutAnimation {
                ReposScreen(
                    navController = navController,
                    modifier = modifier,
                    dataStoreUtil = dataStoreUtil
                )
            }
        }

        composable(NavigationItems.Details.path) { backStackEntry ->
            val owner = backStackEntry.arguments?.getString("owner")
            val repo = backStackEntry.arguments?.getString("repo")

            SlideInOutAnimation {
                RepoDetailsScreen(
                    navController = navController,
                    modifier = modifier,
                    owner = owner,
                    repo = repo
                )
            }
        }

        composable(NavigationItems.Issues.path) { backStackEntry ->
            val owner = backStackEntry.arguments?.getString("owner")
            val repo = backStackEntry.arguments?.getString("repo")

            SlideInOutAnimation {
                IssuesScreen(
                    navController = navController,
                    modifier = modifier,
                    owner = owner,
                    repo = repo
                )
            }
        }

    }


}

